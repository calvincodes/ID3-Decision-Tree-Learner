import entry.InstanceEntry;
import enums.DataSet;
import enums.DataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DriverPart2 {

//    private static ArffFileReader arffFileReader  = new ArffFileReader();
//    private static DecisionTreePrinter decisionTreePrinter = new DecisionTreePrinter();
//    private static Classifier classifier = new Classifier();
//
//    static double[] minAccurancyArray = new double[5];
//    static double[] avgAccurancyArray = new double[5];
//    static double[] maxAccurancyArray = new double[5];
//
////    static DataSet dataSet = DataSet.HEART;
//    static DataSet dataSet = DataSet.DIABETES;
//
//    // TODO: Remove this main FOR SURE.
////    public static void main(String[] args) {
//    public static void temp() {
//
//        Driver.m = 4;
//
//        int[] percentTrain = new int[] {5, 10, 20, 50, 100};
//
//        List<InstanceEntry> allTrainingData = arffFileReader.readArff(dataSet, DataType.TRAIN);
//        List<InstanceEntry> testData = arffFileReader.readArff(dataSet, DataType.TEST);
//
//        for (int percentIteration = 0; percentIteration < 4; percentIteration++) {
//
//            int percentageTraining = percentTrain[percentIteration];
//
//            List<Double> allAccuracies = new ArrayList<>(10);
//
//            for (int iteration = 0; iteration < 10; iteration++) {
//
//                int subsetTrainingCount = (percentageTraining * allTrainingData.size()) / 100;
//
//                List<InstanceEntry> subsetTrainingData = new ArrayList<>();
//
//                for (int i = 1; i <= subsetTrainingCount; i ++) {
//                    Random random = new Random();
//                    subsetTrainingData.add(allTrainingData.get(random.nextInt(allTrainingData.size())));
//                }
//
//                DecisionTreeGenerator decisionTreeGenerator = new DecisionTreeGenerator();
//                Node rootNode = new Node();
//                rootNode.setDepth(-1);
//                rootNode.setInstanceEntries(subsetTrainingData);
//                Node decisionTree = decisionTreeGenerator.generateDecisionTree(Collections.singletonList(rootNode)).get(0);
//
//
//                Double totalClassifications = 1d;
//                int classLabelIndex = testData.get(0).getFeatureValues().length - 1;
//                Double correctClassifications = 0d;
//                int incorrectClassifications = 0;
//                for (InstanceEntry testEntry : testData) {
//                    String actualClass = testEntry.getFeatureValues()[classLabelIndex].toLowerCase();
//                    String classifiedClass = classifier.classify(testEntry, decisionTree).toLowerCase();
////                    System.out.println(totalClassifications
////                            + ": Actual: " + actualClass
////                            + " " + "Predicted: " + classifiedClass);
//                    if (actualClass.equals(classifiedClass)) {
//                        correctClassifications++;
//                    } else {
//                        incorrectClassifications++;
//                    }
//                    totalClassifications++;
//                }
//
//                Double currentAccurancy = (correctClassifications * 100) / totalClassifications;
//                allAccuracies.add(currentAccurancy);
//
////                System.out.println("Number of correctly classified: " + correctClassifications
////                        + " Total number of test instances: " + (totalClassifications - 1));
//            }
//
//            Collections.sort(allAccuracies);
//            minAccurancyArray[percentIteration] = allAccuracies.get(0);
//            maxAccurancyArray[percentIteration] = allAccuracies.get(9);
//            Double sum = 0d;
//            for (Double accuracy : allAccuracies) {
//                sum += accuracy;
//            }
//            avgAccurancyArray[percentIteration] = sum / 10;
//        }
//
//        runFor100();
//
//        System.out.println(Arrays.toString(minAccurancyArray));
//        System.out.println(Arrays.toString(avgAccurancyArray));
//        System.out.println(Arrays.toString(maxAccurancyArray));
//    }
//
//    private static void runFor100() {
//
//        List<InstanceEntry> allTrainingData = arffFileReader.readArff(dataSet, DataType.TRAIN);
//        List<InstanceEntry> testData = arffFileReader.readArff(dataSet, DataType.TEST);
//
//        DecisionTreeGenerator decisionTreeGenerator = new DecisionTreeGenerator();
//        Node rootNode = new Node();
//        rootNode.setDepth(-1);
//        rootNode.setInstanceEntries(allTrainingData);
//        Node decisionTree = decisionTreeGenerator.generateDecisionTree(Collections.singletonList(rootNode)).get(0);
//
//
//        Double totalClassifications = 1d;
//        int classLabelIndex = testData.get(0).getFeatureValues().length - 1;
//        Double correctClassifications = 0d;
//        int incorrectClassifications = 0;
//        for (InstanceEntry testEntry : testData) {
//            String actualClass = testEntry.getFeatureValues()[classLabelIndex].toLowerCase();
//            String classifiedClass = classifier.classify(testEntry, decisionTree).toLowerCase();
//            if (actualClass.equals(classifiedClass)) {
//                correctClassifications++;
//            } else {
//                incorrectClassifications++;
//            }
//            totalClassifications++;
//        }
//
//        Double currentAccurancy = (correctClassifications * 100) / totalClassifications;
//        minAccurancyArray[4] = currentAccurancy;
//        maxAccurancyArray[4] = currentAccurancy;
//        avgAccurancyArray[4] = currentAccurancy;
//    }
}
