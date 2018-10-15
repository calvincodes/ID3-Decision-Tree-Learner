import entry.InstanceEntry;

import java.util.Arrays;
import java.util.List;

public class Node implements Cloneable {

    private String parentFeatureTag;
    private String featureTag;
    private String featureType;
    private Double threshold; // Required for numeric feature types
    private String operator; // <= (left), > (right) (Required for numeric feature types)
    private int positives;
    private int negatives;
    private Double entropy;
    private Double infoGain;
    private List<Node> next;
    private List<InstanceEntry> instanceEntries;
    private int depth;
    private boolean[] featuresUsedTillNow;
    private String parentClassLabel;
    private String classLabel;
    private List<String> priorities;

    public String getParentFeatureTag() {
        return parentFeatureTag;
    }

    public void setParentFeatureTag(String parentFeatureTag) {
        this.parentFeatureTag = parentFeatureTag;
    }

    public String getFeatureTag() {
        return featureTag;
    }

    public void setFeatureTag(String featureTag) {
        this.featureTag = featureTag;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getPositives() {
        return positives;
    }

    public void setPositives(int positives) {
        this.positives = positives;
    }

    public int getNegatives() {
        return negatives;
    }

    public void setNegatives(int negatives) {
        this.negatives = negatives;
    }

    public Double getEntropy() {
        return entropy;
    }

    public void setEntropy(Double entropy) {
        this.entropy = entropy;
    }

    public Double getInfoGain() {
        return infoGain;
    }

    public void setInfoGain(Double infoGain) {
        this.infoGain = infoGain;
    }

    public List<Node> getNext() {
        return next;
    }

    public void setNext(List<Node> next) {
        this.next = next;
    }

    public List<InstanceEntry> getInstanceEntries() {
        return instanceEntries;
    }

    public void setInstanceEntries(List<InstanceEntry> instanceEntries) {
        this.instanceEntries = instanceEntries;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean[] getFeaturesUsedTillNow() {
        return featuresUsedTillNow;
    }

    public void setFeaturesUsedTillNow(boolean[] featuresUsedTillNow) {
        this.featuresUsedTillNow = featuresUsedTillNow;
    }

    public String getParentClassLabel() {
        return parentClassLabel;
    }

    public void setParentClassLabel(String parentClassLabel) {
        this.parentClassLabel = parentClassLabel;
    }

    public String getClassLabel() {
        return classLabel;
    }

    public void setClassLabel(String classLabel) {
        this.classLabel = classLabel;
    }

    public List<String> getPriorities() {
        return priorities;
    }

    public void setPriorities(List<String> priorities) {
        this.priorities = priorities;
    }

    public Node clone() {
        try {
            return (Node) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException("Exception while cloning ", ex);
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "parentFeatureTag='" + parentFeatureTag + '\'' +
                ", featureTag='" + featureTag + '\'' +
                ", featureType='" + featureType + '\'' +
                ", threshold=" + threshold +
                ", operator='" + operator + '\'' +
                ", positives=" + positives +
                ", negatives=" + negatives +
                ", entropy=" + entropy +
                ", infoGain=" + infoGain +
                ", next=" + next +
                ", instanceEntries=" + instanceEntries +
                ", depth=" + depth +
                ", featuresUsedTillNow=" + Arrays.toString(featuresUsedTillNow) +
                ", parentClassLabel='" + parentClassLabel + '\'' +
                ", classLabel='" + classLabel + '\'' +
                ", priorities=" + priorities +
                '}';
    }
}
