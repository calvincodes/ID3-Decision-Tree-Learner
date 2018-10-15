import entry.InstanceEntry;

import java.util.Collections;
import java.util.List;

public class Driver {

    private static ArffFileReader arffFileReader  = new ArffFileReader();
    private static DecisionTreePrinter decisionTreePrinter = new DecisionTreePrinter();
    private static Classifier classifier = new Classifier();

    public static Integer m = null;

    static double accurracy = 0.00d;

    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Usage dt-learn <train-set-file> <test-set-file> m");
            System.exit(-1);
        }

        String trainSetFile = args[0];
        String testSetFile = args[1];
        m = Integer.parseInt(args[2]);

//        DataSet dataSet = null;

//        if (trainSetFile.equals("heart_train.arff") && testSetFile.equals("heart_test.arff")) {
//            dataSet = DataSet.HEART;
//        } else if (trainSetFile.equals("diabetes_train.arff") && testSetFile.equals("diabetes_test.arff")) {
//            dataSet = DataSet.DIABETES;
//        } else {
//            System.err.println("Invalid Input");
//            System.exit(-1);
//        }

        List<InstanceEntry> trainingData = arffFileReader.readArff(trainSetFile);

        DecisionTreeGenerator decisionTreeGenerator = new DecisionTreeGenerator();
        Node rootNode = new Node();
        rootNode.setDepth(-1);
        rootNode.setInstanceEntries(trainingData);
        Node decisionTree = decisionTreeGenerator.generateDecisionTree(Collections.singletonList(rootNode)).get(0);

        decisionTreePrinter.printDecisionTree(decisionTree.getNext());

        System.out.println("<Predictions for the Test Set Instances>");

        List<InstanceEntry> testData = arffFileReader.readArff(testSetFile);

        int totalClassifications = 1;
        int classLabelIndex = testData.get(0).getFeatureValues().length - 1;
        int correctClassifications = 0;
        for (InstanceEntry testEntry : testData) {
            String actualClass = testEntry.getFeatureValues()[classLabelIndex].toLowerCase();
            String classifiedClass = classifier.classify(testEntry, decisionTree).toLowerCase();
            System.out.println(totalClassifications
                                    + ": Actual: " + actualClass
                                    + " " + "Predicted: " + classifiedClass);
            if (actualClass.equals(classifiedClass)) {
                correctClassifications++;
            }
            totalClassifications++;
        }
        accurracy = (correctClassifications * 100) / totalClassifications;
        System.out.print("Number of correctly classified: " + correctClassifications
                            + " Total number of test instances: " + (totalClassifications - 1));
    }
}
