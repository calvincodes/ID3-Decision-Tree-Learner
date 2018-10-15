import entry.InstanceEntry;
import enums.CP;
import enums.ClassLabel;
import enums.FeatureTags;
import enums.FeatureType;
import enums.THAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecisionTreeGenerator {

    private NominalSplitGenerator nominalSplitGenerator = new NominalSplitGenerator();
    private NumericSplitGenerator numericSplitGenerator = new NumericSplitGenerator();
    private static EntropyCalculater entropyCalculater = new EntropyCalculater();
    private SortingHelper sortingHelper = new SortingHelper();

    private int i = 0;

    public List<Node> generateDecisionTree(List<Node> nodes) {

        // Stopping Criteria
        if (nodes == null) {
            return null;
        }

        for (Node node : nodes) {

            List<InstanceEntry> instanceEntries = node.getInstanceEntries();

            // Stopping Criteria
            if (instanceEntries == null) {
                if (node.getPositives() > node.getNegatives()) {
                    node.setClassLabel(ClassLabel.POSITIVE.name());
                } else if (node.getPositives() < node.getNegatives()) {
                    node.setClassLabel(ClassLabel.NEGATIVE.name());
                } else {
                    node.setClassLabel(node.getParentClassLabel());
                }
                continue;
            }

            // Stopping Criteria
            if (instanceEntries.size() < Driver.m) {
                if (node.getPositives() > node.getNegatives()) {
                    node.setClassLabel(ClassLabel.POSITIVE.name());
                } else if (node.getPositives() < node.getNegatives()) {
                    node.setClassLabel(ClassLabel.NEGATIVE.name());
                } else {
                    node.setClassLabel(node.getParentClassLabel());
                }
                continue;
            }

            // Stopping Criteria starts
            // Mark as leaf node if all belongs to same class
            boolean distinctClasses = false;
            int classLabelIndex = instanceEntries.get(0).getFeatureValues().length - 1;
            for (int i = 1; i < instanceEntries.size(); i++) {
                if (!instanceEntries.get(i-1)
                        .getFeatureValues()[classLabelIndex].equals(
                        instanceEntries.get(i).getFeatureValues()[classLabelIndex])) {
                    distinctClasses = true;
                    break;
                }
            }
            if (!distinctClasses) {
                if (node.getPositives() > node.getNegatives()) {
                    node.setClassLabel(ClassLabel.POSITIVE.name());
                } else if (node.getPositives() < node.getNegatives()) {
                    node.setClassLabel(ClassLabel.NEGATIVE.name());
                } else {
                    node.setClassLabel(node.getParentClassLabel());
                }
                continue;
            }
            // Stopping Criteria ends

            List<Node> dummyNodes;
            // Root Node Case
            if (node.getDepth() == -1) {
                dummyNodes = generateDepthNegativeOneRootNodes(instanceEntries);
            } else {
                dummyNodes = generateRootNodes(node);
            }

            for (Node dummyNode : dummyNodes) {
                // Generate Candidate Split for the node
                if (dummyNode.getFeatureType().equals(FeatureType.NOMINAL.name())) {
                    setChildrenAndInfoGainForNominal(dummyNode, nominalSplitGenerator.determineCandidateSplit(dummyNode));
                } else {
                    setChildrenAndInfoGainForNumerical(dummyNode, numericSplitGenerator.determineCandidateSplit(dummyNode));
                }
            }

            Node bestNode = null;
            for (Node dummyNode : dummyNodes) {
                if (bestNode == null ||
                        (bestNode.getInfoGain() < dummyNode.getInfoGain())) {
                    bestNode = dummyNode;
                }
            }

            node.setNext(sortingHelper.sortNodes(bestNode.getNext()));

            i++;

            generateDecisionTree(bestNode.getNext());
        }

        return nodes;
    }

    private static List<Node> generateRootNodes(Node node) {

        List<InstanceEntry> instanceEntries = node.getInstanceEntries();
        List<Node> possibleRootNodes = new ArrayList<>();

        int positives = 0;
        int negatives = 0;
        int lastIndex = instanceEntries.get(0).getFeatureTags().length - 1;
        for (InstanceEntry instanceEntry : instanceEntries) {
            if (instanceEntry.getFeatureValues()[lastIndex].equals(ClassLabel.POSITIVE.name())) {
                positives++;
            } else {
                negatives++;
            }
        }

        for (int i = 0; i < instanceEntries.get(0).getFeatureTags().length; i++) {
            if (
                    // Allowing repetition of feature vectors
//                    !node.getFeaturesUsedTillNow()[i]
//                    &&
                    !instanceEntries.get(0).getFeatureTags()[i].equals(FeatureTags.CLASSLABEL.name())) {
                Node rootNode = new Node();
                rootNode.setFeatureTag(instanceEntries.get(0).getFeatureTags()[i]);
                rootNode.setFeatureType(instanceEntries.get(0).getFeatureTypes()[i]);
                rootNode.setEntropy(
                        entropyCalculater.calculateEntropyForRootNodes(Double.valueOf(positives), Double.valueOf(negatives)));
                rootNode.setPositives(positives);
                rootNode.setNegatives(negatives);
                rootNode.setInstanceEntries(instanceEntries);
                rootNode.setDepth(node.getDepth());
                rootNode.setFeaturesUsedTillNow(node.getFeaturesUsedTillNow().clone());
                rootNode.getFeaturesUsedTillNow()[i] = true;
                possibleRootNodes.add(rootNode);
            }
        }

        return possibleRootNodes;
    }

    private static List<Node> generateDepthNegativeOneRootNodes(List<InstanceEntry> instanceEntries) {

        List<Node> possibleRootNodes = new ArrayList<>();

        int positives = 0;
        int negatives = 0;
        int lastIndex = instanceEntries.get(0).getFeatureTags().length - 1;
        for (InstanceEntry instanceEntry : instanceEntries) {
            if (instanceEntry.getFeatureValues()[lastIndex].equals(ClassLabel.POSITIVE.name())) {
                positives++;
            } else {
                negatives++;
            }
        }

        for (int i = 0; i < instanceEntries.get(0).getFeatureTags().length; i++) {
            if (!instanceEntries.get(0).getFeatureTags()[i].equals(FeatureTags.CLASSLABEL.name())) {
                Node rootNode = new Node();
                rootNode.setFeatureTag(instanceEntries.get(0).getFeatureTags()[i]);
                rootNode.setFeatureType(instanceEntries.get(0).getFeatureTypes()[i]);
                rootNode.setEntropy(
                        entropyCalculater.calculateEntropyForRootNodes(Double.valueOf(positives), Double.valueOf(negatives)));
                rootNode.setPositives(positives);
                rootNode.setNegatives(negatives);
                rootNode.setInstanceEntries(instanceEntries);
                rootNode.setDepth(-1);
                rootNode.setFeaturesUsedTillNow(new boolean[instanceEntries.get(0).getFeatureTags().length]);
                for (int j = 0; j < rootNode.getFeaturesUsedTillNow().length; j++) {
                    if (i == j) {
                        rootNode.getFeaturesUsedTillNow()[j] = true;
                    } else {
                        rootNode.getFeaturesUsedTillNow()[j] = false;
                    }
                }
                possibleRootNodes.add(rootNode);
            }
        }

        return possibleRootNodes;
    }

    private void setChildrenAndInfoGainForNominal(Node root, List<Node> childrenNodes) {

        Double entropyOfChildrenGivenRoot = 0.00d;
        for (Node childNode : childrenNodes) {
            entropyOfChildrenGivenRoot
                    += ( Double.valueOf(childNode.getPositives() + childNode.getNegatives())
                    / Double.valueOf(root.getPositives() + root.getNegatives())
            ) * childNode.getEntropy();
        }
        root.setInfoGain(root.getEntropy() - entropyOfChildrenGivenRoot);
        root.setNext(childrenNodes);
    }

    private void setChildrenAndInfoGainForNumerical(Node root, Map<Double, List<Node>> threshold2ChildrenNodes) {

        Map<Double, Double> threshold2InfoGains = new HashMap<>();

        for (Map.Entry<Double, List<Node>> threshold2ChildrenNode : threshold2ChildrenNodes.entrySet()) {
            Double entropyOfChildrenGivenRoot = 0.00d;
            for (Node childNode : threshold2ChildrenNode.getValue()) {

                entropyOfChildrenGivenRoot
                        += ( Double.valueOf(childNode.getPositives() + childNode.getNegatives())
                        / Double.valueOf(root.getPositives() + root.getNegatives())
                ) * childNode.getEntropy();
            }
            threshold2InfoGains.put(threshold2ChildrenNode.getKey(), root.getEntropy() - entropyOfChildrenGivenRoot);
        }

        Double maxInfoGain = Double.MIN_VALUE;
        Double bestThreshold = -1d;
        for (Map.Entry<Double, Double> threshold2InfoGain : threshold2InfoGains.entrySet()) {
            if (maxInfoGain < threshold2InfoGain.getValue()) {
                bestThreshold = threshold2InfoGain.getKey();
                maxInfoGain = threshold2InfoGain.getValue();
            }
        }

        root.setInfoGain(maxInfoGain);
        root.setNext(threshold2ChildrenNodes.get(bestThreshold));
    }
}
