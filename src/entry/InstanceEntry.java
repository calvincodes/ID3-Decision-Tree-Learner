package entry;

import java.util.Arrays;

public class InstanceEntry {

    private String[] featureTags;
    private String[] featureValues;
    private String[] featureTypes;

    public String[] getFeatureTags() {
        return featureTags;
    }

    void setFeatureTags(String[] featureTags) {
        this.featureTags = featureTags;
    }

    public String[] getFeatureValues() {
        return featureValues;
    }

    void setFeatureValues(String[] featureValues) {
        this.featureValues = featureValues;
    }

    public String[] getFeatureTypes() {
        return featureTypes;
    }

    void setFeatureTypes(String[] featureTypes) {
        this.featureTypes = featureTypes;
    }

    @Override
    public String toString() {
        return "InstanceEntry{" +
                "featureTags=" + Arrays.toString(featureTags) +
                ", featureValues=" + Arrays.toString(featureValues) +
                ", featureTypes=" + Arrays.toString(featureTypes) +
                '}';
    }
}
