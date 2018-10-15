import enums.CP;
import enums.EXANG;
import enums.FBS;
import enums.FeatureTags;
import enums.RESTECG;
import enums.Sex;
import enums.Slope;
import enums.THAL;

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
        switch (FeatureTags.valueOf(parentFeatureTag)) {

            // @attribute 'sex' { female, male}
            case SEX:
                if (childrenNodes.size() != 2) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(Sex.MALE.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), Sex.MALE.name()));
                    }

                    if (!exisistingVals.contains(Sex.FEMALE.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), Sex.FEMALE.name()));
                    }
                }
                return;

            // @attribute 'cp' { typ_angina, asympt, non_anginal, atyp_angina}
            case CP:
                if (childrenNodes.size() != 4) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(CP.TYP_ANGINA.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), CP.TYP_ANGINA.name()));
                    }
                    if (!exisistingVals.contains(CP.ASYMPT.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), CP.ASYMPT.name()));
                    }
                    if (!exisistingVals.contains(CP.NON_ANGINAL.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), CP.NON_ANGINAL.name()));
                    }
                    if (!exisistingVals.contains(CP.ATYP_ANGINA.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), CP.ATYP_ANGINA.name()));
                    }
                }
                return;


            // @attribute 'fbs' { t, f}
            case FBS:
                if (childrenNodes.size() != 2) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(FBS.T.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), FBS.T.name()));
                    }

                    if (!exisistingVals.contains(FBS.F.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), FBS.F.name()));
                    }
                }
                return;

            // @attribute 'restecg' { left_vent_hyper, normal, st_t_wave_abnormality}
            case RESTECG:
                if (childrenNodes.size() != 3) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(RESTECG.LEFT_VENT_HYPER.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), RESTECG.LEFT_VENT_HYPER.name()));
                    }
                    if (!exisistingVals.contains(RESTECG.NORMAL.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), RESTECG.NORMAL.name()));
                    }
                    if (!exisistingVals.contains(RESTECG.ST_T_WAVE_ABNORMALITY.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), RESTECG.ST_T_WAVE_ABNORMALITY.name()));
                    }
                }
                return;

            // @attribute 'exang' { no, yes}
            case EXANG:
                if (childrenNodes.size() != 2) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(EXANG.NO.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), EXANG.NO.name()));
                    }

                    if (!exisistingVals.contains(EXANG.YES.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), EXANG.YES.name()));
                    }
                }
                return;

            // @attribute 'slope' { up, flat, down}
            case SLOPE:
                if (childrenNodes.size() != 3) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(Slope.UP.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), Slope.UP.name()));
                    }
                    if (!exisistingVals.contains(Slope.FLAT.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), Slope.FLAT.name()));
                    }
                    if (!exisistingVals.contains(Slope.DOWN.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), Slope.DOWN.name()));
                    }
                }
                return;

            // @attribute 'thal' { fixed_defect, normal, reversable_defect}
            case THAL:
                if (childrenNodes.size() != 3) {
                    for (Node node : childrenNodes) {
                        exisistingVals.add(node.getFeatureTag());
                    }

                    if (!exisistingVals.contains(THAL.FIXED_DEFECT.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), THAL.FIXED_DEFECT.name()));
                    }
                    if (!exisistingVals.contains(THAL.NORMAL.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), THAL.NORMAL.name()));
                    }
                    if (!exisistingVals.contains(THAL.REVERSABLE_DEFECT.name())) {
                        childrenNodes.add(dummyNonExistentNode(childrenNodes.get(0), THAL.REVERSABLE_DEFECT.name()));
                    }
                }
                return;
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
