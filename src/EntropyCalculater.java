import entry.InstanceEntry;
import enums.ClassLabel;
import enums.FeatureType;

import java.util.HashMap;
import java.util.List;

public class EntropyCalculater {

    public Double calculateEntropyForRootNodes(Double positives, Double negatives) {

        if (positives == 0 || negatives == 0) {
            return 0d; // No bits required as this is a pure set.
        }

        return - (
                (positives / (positives + negatives))
                        * (Math.log10(positives / (positives + negatives)) / Math.log10(2))
        )
                - (
                (negatives / (positives + negatives))
                        * (Math.log10(negatives / (positives + negatives)) / Math.log10(2))
        )
                ;
    }

//    public Double calculateEntropyForFeature(List<InstanceEntry> instanceEntries, int featureIndex) {
//
//        if (instanceEntries.get(0).getFeatureTypes()[featureIndex].equals(FeatureType.NOMINAL.name())) {
//            return calculateEntropyForNominalFeature(instanceEntries, featureIndex);
//        } else {
//            return calculateEntropyForNumericalFeature(instanceEntries, featureIndex);
//        }
//    }
//
//    private Double calculateEntropyForNominalFeature(List<InstanceEntry> instanceEntries, int featureIndex) {
//
//        HashMap<String, Integer> positiveInstances = new HashMap<>();
//        HashMap<String, Integer> negativeInstances = new HashMap<>();
//
//        Double positives = 0d;
//        Double negatives = 0d;
//        int lastIndex = instanceEntries.get(0).getFeatureTags().length - 1;
//        for (InstanceEntry instanceEntry : instanceEntries) {
//            if (instanceEntry.getFeatureValues()[lastIndex].equals(ClassLabel.POSITIVE.name())) {
//                positives++;
//            } else {
//                negatives++;
//            }
//        }
//
//        positiveInstances.put(instanceEntries.get(0).getFeatureTags()[featureIndex], positives.intValue());
//        negativeInstances.put(instanceEntries.get(0).getFeatureTags()[featureIndex], negatives.intValue());
//
//        Double entropy = - (
//                            (positives / (positives + negatives))
//                                * (Math.log10(positives / (positives + negatives)) / Math.log10(2))
//                            )
//                        - (
//                            (negatives / (positives + negatives))
//                                * (Math.log10(positives / (positives + negatives)) / Math.log10(2))
//                        )
//                ;
//        return entropy;
//    }
//
//    private Double calculateEntropyForNumericalFeature(List<InstanceEntry> instanceEntries, int featureIndex) {
//        return 0.00d;
//    }
}
