import entry.DiabetesEntry;
import entry.HeartDiseaseEntry;
import entry.InstanceEntry;
import enums.DataSet;
import enums.DataType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArffFileReader {

    // TODO: This is a trivial case of Factory Design Pattern, where you pass the classification type
    // TODO: and get the corresponding entry read. But as we are short on time and no marks for modularisation
    // TODO: so keeping this as a TODO for future. :P

    public List<InstanceEntry> readArff(DataSet dataSet, DataType dataType) {

        List<InstanceEntry> arffEntries = new ArrayList<>();

        String fileName;
        if (dataSet.equals(DataSet.HEART)) {
            fileName = dataType.equals(DataType.TRAIN) ? "heart_train.arff" : "heart_test.arff";
        } else {
            fileName = dataType.equals(DataType.TRAIN) ? "diabetes_train.arff" : "diabetes_test.arff";
        }

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);

////        File file = new File(classLoader.getResource(fileName).getFile());
//        File file = new File(fileName);
//        try {
//            FileInputStream fstream = new FileInputStream(fileName);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // This will reference one line at a time
        String line;

        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = new FileReader(file);

//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader = new BufferedReader(fileReader);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            while((line = bufferedReader.readLine()) != null) {

                if (line.startsWith("@")) {
                    // Current line is a comment. IGNORE
                    continue;
                }

                List<String> featureValues = Arrays.asList(line.split(","));
                InstanceEntry instanceEntry;
                if (dataSet.equals(DataSet.HEART)) {
                    instanceEntry = new HeartDiseaseEntry(featureValues);
                } else {
                    instanceEntry = new DiabetesEntry(featureValues);
                }
                arffEntries.add(instanceEntry);
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
}
