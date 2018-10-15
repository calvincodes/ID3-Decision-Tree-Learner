import java.util.List;

public class SortingHelper {

    public List<Node> sortNodes(List<Node> nodes) {

        if (nodes == null) {
            return nodes;
        }

        String parentFeatureTag = nodes.get(0).getParentFeatureTag();

        if (parentFeatureTag == null) {
            return nodes;
        }

        nodes.sort((node1, node2) -> {
            String featureTag1 = node1.getFeatureTag();
            String featureTag2 = node2.getFeatureTag();

            int result = 0;

            if (node1.getPriorities() != null) {
                int f1Index = node1.getPriorities().indexOf(featureTag1);
                int f2Index = node1.getPriorities().indexOf(featureTag2);

                if (f1Index < f2Index) {
                    result = -1;
                } else if (f1Index > f2Index) {
                    result = 1;
                } else if (f1Index == f2Index) {
                    result = 0;
                }
            }

            return result;
        });
        return nodes;
    }
}
