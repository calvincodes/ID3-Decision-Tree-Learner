import entry.InstanceEntry;
import enums.ClassLabel;
import enums.FeatureType;
import enums.Operator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NominalSplitGenerator {

    private EntropyCalculater entropyCalculater = new EntropyCalculater();
    private NonExistentNominalNodeCreator nonExistentNominalNodeCreator = new NonExistentNominalNodeCreator();

    public List<Node> determineCandidateSplit(Node root) {

        if (root.getFeatureType().equals(FeatureType.NOMINAL.name())) {
            return generateCandidateSplit(root);
        }

        throw new RuntimeException("Numeric feature passed to NominalSplitGenerator");
    }

    private List<Node> generateCandidateSplit(Node root) {

        List<InstanceEntry> instanceEntries = root.getInstanceEntries();
        List<Node> childrenNodes = new ArrayList<>();

        Set<String> probableChildTags = new HashSet<>();
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
            probableChildTags.add(instanceEntries.get(i).getFeatureValues()[indexOfParentTag]);
        }

        for (String childTag : probableChildTags) {
            Node childNode = new Node();
            childNode.setParentFeatureTag(root.getFeatureTag());
            childNode.setFeatureTag(childTag);
            childNode.setPriorities(instanceEntries.get(0).getPriorityMap().get(root.getFeatureTag()));
            childNode.setFeatureType(root.getFeatureType());
            childNode.setDepth(root.getDepth()+1);
            childNode.setOperator(Operator.EQUAL.getDisplayName());
            childNode.setFeaturesUsedTillNow(root.getFeaturesUsedTillNow().clone());
            childNode.getFeaturesUsedTillNow()[indexOfParentTag] = true;
            childNode.setParentClassLabel(
                    root.getPositives() > root.getNegatives() ? ClassLabel.POSITIVE.name() : ClassLabel.NEGATIVE.name());

            List<InstanceEntry> reducedInstanceEntrySet
                    = getReducedInstanceEntrySet(instanceEntries, indexOfParentTag, childTag);
            int positives = 0;
            int negatives = 0;
            int lastIndex = reducedInstanceEntrySet.get(0).getFeatureTags().length - 1;
            for (InstanceEntry instanceEntry : reducedInstanceEntrySet) {
                if (instanceEntry.getFeatureValues()[lastIndex].equals(ClassLabel.POSITIVE.name())) {
                    positives++;
                } else {
                    negatives++;
                }
            }
            childNode.setInstanceEntries(reducedInstanceEntrySet);
            childNode.setPositives(positives);
            childNode.setNegatives(negatives);
            childNode.setEntropy(
                    entropyCalculater.calculateEntropyForRootNodes(Double.valueOf(positives), Double.valueOf(negatives)));
            childrenNodes.add(childNode);
        }

        nonExistentNominalNodeCreator.addNonExistentNominalNode(childrenNodes);
        return childrenNodes;
    }

    private List<InstanceEntry> getReducedInstanceEntrySet(
            List<InstanceEntry> trainingInstanceEntry, Integer currentFeatureIndex, String currentFeatureVal) {

        List<InstanceEntry> reducedInstanceEntries = new ArrayList<>();

        for (int i = 0; i < trainingInstanceEntry.size(); i++) {
            if (trainingInstanceEntry.get(i).getFeatureValues()[currentFeatureIndex].equals(currentFeatureVal)) {
                reducedInstanceEntries.add(trainingInstanceEntry.get(i));
            }
        }

        return reducedInstanceEntries;
    }
}
