import entry.InstanceEntry;
import enums.FeatureTags;
import enums.FeatureType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArffFileReader {

    // TODO: This is a trivial case of Factory Design Pattern, where you pass the classification type
    // TODO: and get the corresponding entry read. But as we are short on time and no marks for modularisation
    // TODO: so keeping this as a TODO for future. :P

    public List<InstanceEntry> readArff(String fileName) {

        List<InstanceEntry> arffEntries = new ArrayList<>();
        FileReader file = null;
        try {
            file = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + fileName);
            e.printStackTrace();
            System.exit(-1);
        }

        // This will reference one line at a time
        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(file);

            List<String> featureTags = new ArrayList<>();
            List<String> featureTypes = new ArrayList<>();
            HashMap<String, List<String>> priorityMap = new HashMap<>();
            while((line = bufferedReader.readLine()) != null) {

                if (line.startsWith("@attribute")) {
                    String[] header = line.split("'");
                    if (header[2].equals(" real") || header[2].equals(" numeric")) {
                        featureTypes.add(FeatureType.NUMERIC.name());
                        featureTags.add(header[1].toUpperCase());
                    } else {
                        featureTypes.add(FeatureType.NOMINAL.name());
                        if (header[1].equalsIgnoreCase("class")) {
                            featureTags.add(FeatureTags.CLASSLABEL.name());
                        } else {
                            featureTags.add(header[1].toUpperCase());
                        }
                        header[2] = header[2].replace('{', ' ');
                        header[2] = header[2].replace('}', ' ');
                        header[2] = header[2].replaceAll("\\s+", "");
                        String[] priorities = header[2].split(",");
                        List<String> priorityList = Arrays.asList(priorities);
                        priorityList.replaceAll(String::toUpperCase);
                        priorityMap.put(header[1].toUpperCase(), priorityList);
                    }
                } else if (line.startsWith("@")) {
                    continue;
                } else {
                    List<String> featureValues = Arrays.asList(line.split(","));
                    InstanceEntry instanceEntry = getGenericInstanceEntry(featureTags, featureTypes, priorityMap, featureValues);
                    arffEntries.add(instanceEntry);
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'" + Arrays.toString(ex.getStackTrace()));
            System.exit(-1);
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'" + Arrays.toString(ex.getStackTrace()));
            System.exit(-1);
        }

        return arffEntries;
    }

    private InstanceEntry getGenericInstanceEntry(List<String> featureTags,
                                                    List<String> featureTypes,
                                                    HashMap<String, List<String>> priorityMap,
                                                    List<String> featureValues) {

        InstanceEntry instanceEntry = new InstanceEntry();

        instanceEntry.setFeatureTags(featureTags.toArray(new String[featureTags.size()]));
        instanceEntry.setFeatureTypes(featureTypes.toArray(new String[featureTypes.size()]));

        featureValues.replaceAll(String::toUpperCase);
        instanceEntry.setFeatureValues(featureValues.toArray(new String[featureValues.size()]));

        instanceEntry.setPriorityMap(priorityMap);

        return instanceEntry;
    }
}
