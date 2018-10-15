import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonExistentNominalNodeCreator {

    public void addNonExistentNominalNode(List<Node> childrenNodes) {

        if (childrenNodes == null || childrenNodes.isEmpty()) {
            return;
        }

        String parentFeatureTag = childrenNodes.get(0).getParentFeatureTag();

        if (parentFeatureTag == null) {
            return;
        }

        Set<String> exisistingVals = new HashSet<>();
        int reqSize = childrenNodes.get(0).getPriorities().size();
        if (childrenNodes.size() < reqSize) {
            for (Node node : childrenNodes) {
                exisistingVals.add(node.getFeatureTag());
            }

            for (String priority : childrenNodes.get(0).getPriorities()) {
                if (!exisistingVals.contains(priority)) {
                    childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), priority));
                }
            }
        }
    }

    private Node dummyNonExistentNode(Node sampleNode, String featureTag) {

        Node newNode = sampleNode.clone();
        newNode.setFeatureTag(featureTag);
        newNode.setNext(null);
        newNode.setInfoGain(0d);
        newNode.setInstanceEntries(null);
        newNode.setPositives(0);
        newNode.setNegatives(0);
        newNode.setEntropy(0d);
        return newNode;
    }
}
