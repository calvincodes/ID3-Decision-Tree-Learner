import enums.FeatureType;

import java.text.DecimalFormat;
import java.util.List;

public class DecisionTreePrinter {

    private DecimalFormat df = new DecimalFormat("#.######");

    public void printDecisionTree(List<Node> nodes) {

        if (nodes == null || nodes.isEmpty()) {
            return;
        }

        for (Node node : nodes) {
            int depth = node.getDepth();
            for (int i = 0; i < depth; i++) {
                System.out.print("|\t");
            }

            System.out.print(node.getParentFeatureTag().toLowerCase() + " ");
            System.out.print(node.getOperator() + " ");
            if (FeatureType.NOMINAL.name().equals(node.getFeatureType())) {
                System.out.print(node.getFeatureTag().toLowerCase() + " ");
            } else {
                System.out.print(String.format("%.6f", node.getThreshold()) + " ");
            }
            System.out.print("[" + node.getNegatives() + " ");
            System.out.print(node.getPositives() + "]");
            if (node.getNext() == null || node.getNext().isEmpty()) {
                System.out.print(": " + node.getClassLabel().toLowerCase());
            }
            System.out.print("\n");

            printDecisionTree(node.getNext());
        }
    }
}
