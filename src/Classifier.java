import entry.InstanceEntry;
import enums.FeatureType;
import enums.Operator;

import java.util.List;

public class Classifier {

    private String classificationResult;

    public String classify(InstanceEntry testEntry, Node decisionTreeRoot) {

        classificationResult = "";
        traverseTree(testEntry, decisionTreeRoot.getNext());
        return classificationResult;
    }

    private void traverseTree(InstanceEntry testEntry, List<Node> nodes) {

        if (nodes == null || nodes.isEmpty()) {
            return;
        }

        for (Node node : nodes) {

//            if (node.getNext() == null || node.getNext().isEmpty()) {
//                classificationResult = node.getClassLabel();
//                return;
//            }

            int indexOfFeatureTag = -1;
            for (int i = 0; i < testEntry.getFeatureTags().length; i++) {
                if (testEntry.getFeatureTags()[i].equalsIgnoreCase(node.getFeatureTag())
                        || testEntry.getFeatureTypes()[i].equalsIgnoreCase(node.getFeatureTag())
                        || testEntry.getFeatureTags()[i].equalsIgnoreCase(node.getParentFeatureTag())) {
                    indexOfFeatureTag = i;
                    break;
                }
            }

            if (Operator.EQUAL.getDisplayName().equals(node.getOperator())) {

                String featureValueOfTest = testEntry.getFeatureValues()[indexOfFeatureTag];
                if (node.getFeatureTag().equalsIgnoreCase(featureValueOfTest)) {

                    if (node.getNext() == null || node.getNext().isEmpty()) {
                        if ("".equals(classificationResult)) {
                            classificationResult = node.getClassLabel();
                            return;
                        }
                    }
                    // This node matches the test data set. Traverse more from here.
                    traverseTree(testEntry, node.getNext());
                }
            } else if (Operator.GREATER.getDisplayName().equals(node.getOperator())) {

                Double featureValueOfTest = Double.valueOf(testEntry.getFeatureValues()[indexOfFeatureTag]);
                if (featureValueOfTest > node.getThreshold()) {
                    if (node.getNext() == null || node.getNext().isEmpty()) {
                        if ("".equals(classificationResult)) {
                            classificationResult = node.getClassLabel();
                            return;
                        }
                    }
                    // This node matches the test data set. Traverse more from here.
                    traverseTree(testEntry, node.getNext());
                }
            }  else if (Operator.LESS_THAN_EQUAL.getDisplayName().equals(node.getOperator())) {

                Double featureValueOfTest = Double.valueOf(testEntry.getFeatureValues()[indexOfFeatureTag]);
                if (featureValueOfTest <= node.getThreshold()) {

                    if (node.getNext() == null || node.getNext().isEmpty()) {
                        if ("".equals(classificationResult)) {
                            classificationResult = node.getClassLabel();
                            return;
                        }
                    }
                    // This node matches the test data set. Traverse more from here.
                    traverseTree(testEntry, node.getNext());
                }
            }
        }
    }
}
