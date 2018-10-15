package entry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InstanceEntry {

    private String[] featureTags;
    private String[] featureValues;
    private String[] featureTypes;
    private HashMap<String, List<String>> priorityMap;

    public String[] getFeatureTags() {
        return featureTags;
    }

    public void setFeatureTags(String[] featureTags) {
        this.featureTags = featureTags;
    }

    public String[] getFeatureValues() {
        return featureValues;
    }

    public void setFeatureValues(String[] featureValues) {
        this.featureValues = featureValues;
    }

    public String[] getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(String[] featureTypes) {
        this.featureTypes = featureTypes;
    }

    public HashMap<String, List<String>> getPriorityMap() {
        return priorityMap;
    }

    public void setPriorityMap(HashMap<String, List<String>> priorityMap) {
        this.priorityMap = priorityMap;
    }

    @Override
    public String toString() {
        return "InstanceEntry{" +
                "featureTags=" + Arrays.toString(featureTags) +
                ", featureValues=" + Arrays.toString(featureValues) +
                ", featureTypes=" + Arrays.toString(featureTypes) +
                ", priorityMap=" + priorityMap +
                '}';
    }
}
