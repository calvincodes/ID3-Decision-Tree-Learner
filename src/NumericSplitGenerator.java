import entry.InstanceEntry;
import enums.ClassLabel;
import enums.FeatureType;
import enums.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumericSplitGenerator {

    private EntropyCalculater entropyCalculater = new EntropyCalculater();

    public Map<Double, List<Node>> determineCandidateSplit(Node root) {

        if (root.getFeatureType().equals(FeatureType.NUMERIC.name())) {
            return generateCandidateSplit(root);
        }

        throw new RuntimeException("Nominal feature passed to NumericSplitGenerator");
    }

    private Map<Double, List<Node>> generateCandidateSplit(Node root) {

        List<InstanceEntry> instanceEntries = root.getInstanceEntries();
        Map<Double, List<Node>> threshold2ChildrenNodes = new HashMap<>();

        Set<Double> distinctFeatureValues = new HashSet<>();
        Integer indexOfParentTag = null;
        for (int i = 0; i < instanceEntries.get(0).getFeatureTags().length; i++) {
            // For nominal, instance entry tag or value should match with the root node's feature tag.
            // Example, root node's feature tag can be - thal, fixed_defect, normal, reversable_defect
            if (instanceEntries.get(0).getFeatureTags()[i].equals(root.getFeatureTag())
                    || instanceEntries.get(0).getFeatureTypes()[i].equals(root.getFeatureTag())
                    || instanceEntries.get(0).getFeatureTags()[i].equals(root.getParentFeatureTag())) {
                indexOfParentTag = i;
                break;
            }
        }

        for (int i = 0; i < instanceEntries.size(); i++) {
            distinctFeatureValues.add(Double.valueOf(instanceEntries.get(i).getFeatureValues()[indexOfParentTag]));
        }

        List<Double> sortedDistinctFeatureValues = new ArrayList(distinctFeatureValues);
        Collections.sort(sortedDistinctFeatureValues);

        for (int i = 1; i < sortedDistinctFeatureValues.size(); i++) {

            Double currentThreshold = (sortedDistinctFeatureValues.get(i-1) + sortedDistinctFeatureValues.get(i)) / 2;
            threshold2ChildrenNodes.put(
                    currentThreshold, generateNodesForCurrentThreshold(root, currentThreshold, indexOfParentTag));
        }

        return threshold2ChildrenNodes;
    }

    private List<Node> generateNodesForCurrentThreshold(Node root, Double currentThreshold, Integer indexOfParentTag) {

        List<InstanceEntry> instanceEntries = root.getInstanceEntries();
        List<Node> childrenNodes = new ArrayList<>();

        Node lessThanEqualChild = new Node();
        lessThanEqualChild.setParentFeatureTag(root.getFeatureTag());
        lessThanEqualChild.setFeatureTag(root.getFeatureTag());
        lessThanEqualChild.setFeatureType(root.getFeatureType());
        lessThanEqualChild.setParentClassLabel(
                root.getPositives() > root.getNegatives() ? ClassLabel.POSITIVE.name() : ClassLabel.NEGATIVE.name());
        lessThanEqualChild.setDepth(root.getDepth()+1);
        lessThanEqualChild.setFeaturesUsedTillNow(root.getFeaturesUsedTillNow().clone());
        lessThanEqualChild.getFeaturesUsedTillNow()[indexOfParentTag] = true;

        lessThanEqualChild.setThreshold(currentThreshold);
        lessThanEqualChild.setOperator(Operator.LESS_THAN_EQUAL.getDisplayName());
        List<InstanceEntry> reducedInstanceEntrySetForLessThanEqualNode
                = getReducedInstanceEntrySet(
                instanceEntries, indexOfParentTag, currentThreshold, Operator.LESS_THAN_EQUAL.getDisplayName());
        int positives = 0;
        int negatives = 0;
        int lastIndex = reducedInstanceEntrySetForLessThanEqualNode.get(0).getFeatureTags().length - 1;
        for (InstanceEntry instanceEntry : reducedInstanceEntrySetForLessThanEqualNode) {
            if (instanceEntry.getFeatureValues()[lastIndex].equals(ClassLabel.POSITIVE.name())) {
                positives++;
            } else {
                negatives++;
            }
        }
        lessThanEqualChild.setInstanceEntries(reducedInstanceEntrySetForLessThanEqualNode);
        lessThanEqualChild.setPositives(positives);
        lessThanEqualChild.setNegatives(negatives);
        lessThanEqualChild.setEntropy(
                entropyCalculater.calculateEntropyForRootNodes(Double.valueOf(positives), Double.valueOf(negatives)));

        Node greaterThanChild = new Node();
        greaterThanChild.setParentFeatureTag(root.getFeatureTag());
        greaterThanChild.setFeatureTag(root.getFeatureTag());
        greaterThanChild.setFeatureType(root.getFeatureType());
        greaterThanChild.setParentClassLabel(
                root.getPositives() > root.getNegatives() ? ClassLabel.POSITIVE.name() : ClassLabel.NEGATIVE.name());
        greaterThanChild.setDepth(root.getDepth()+1);
        greaterThanChild.setFeaturesUsedTillNow(root.getFeaturesUsedTillNow().clone());
        greaterThanChild.getFeaturesUsedTillNow()[indexOfParentTag] = true;

        greaterThanChild.setThreshold(currentThreshold);
        greaterThanChild.setOperator(Operator.GREATER.getDisplayName());
        List<InstanceEntry> reducedInstanceEntrySetForGreaterThanNode
                = getReducedInstanceEntrySet(
                instanceEntries, indexOfParentTag, currentThreshold, Operator.GREATER.getDisplayName());
        positives = 0;
        negatives = 0;
        lastIndex = reducedInstanceEntrySetForGreaterThanNode.get(0).getFeatureTags().length - 1;
        for (InstanceEntry instanceEntry : reducedInstanceEntrySetForGreaterThanNode) {
            if (instanceEntry.getFeatureValues()[lastIndex].equals(ClassLabel.POSITIVE.name())) {
                positives++;
            } else {
                negatives++;
            }
        }
        greaterThanChild.setInstanceEntries(reducedInstanceEntrySetForGreaterThanNode);
        greaterThanChild.setPositives(positives);
        greaterThanChild.setNegatives(negatives);
        greaterThanChild.setEntropy(
                entropyCalculater.calculateEntropyForRootNodes(Double.valueOf(positives), Double.valueOf(negatives)));

        childrenNodes.add(lessThanEqualChild);
        childrenNodes.add(greaterThanChild);

        return childrenNodes;
    }

    private List<InstanceEntry> getReducedInstanceEntrySet(
            List<InstanceEntry> trainingInstanceEntry, Integer currentFeatureIndex, Double threshold, String operator) {

        List<InstanceEntry> reducedInstanceEntries = new ArrayList<>();

        if (operator.equals(Operator.GREATER.getDisplayName())) {
            for (int i = 0; i < trainingInstanceEntry.size(); i++) {
                if (Double.valueOf(trainingInstanceEntry.get(i).getFeatureValues()[currentFeatureIndex]) > threshold) {
                    reducedInstanceEntries.add(trainingInstanceEntry.get(i));
                }
            }
        } else {
            for (int i = 0; i < trainingInstanceEntry.size(); i++) {
                if (Double.valueOf(trainingInstanceEntry.get(i).getFeatureValues()[currentFeatureIndex]) <= threshold) {
                    reducedInstanceEntries.add(trainingInstanceEntry.get(i));
                }
            }
        }

        return reducedInstanceEntries;
    }
}
