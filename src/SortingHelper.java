import enums.CP;
import enums.EXANG;
import enums.FBS;
import enums.FeatureTags;
import enums.RESTECG;
import enums.Sex;
import enums.Slope;
import enums.THAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        switch (FeatureTags.valueOf(parentFeatureTag)) {

            // @attribute 'sex' { female, male}
            case SEX:
                nodes.sort((node1, node2) -> {
                    String featureTag1 = node1.getFeatureTag();
                    String featureTag2 = node2.getFeatureTag();

                    if (featureTag1.equals(Sex.FEMALE.name())) {
                        return -1;
                    }
                    if (featureTag2.equals(Sex.FEMALE.name())) {
                        return 1;
                    }

                    return 0;
                });
                return nodes;

            // @attribute 'cp' { typ_angina, asympt, non_anginal, atyp_angina}
            case CP:
                nodes.sort((node1, node2) -> {
                    String featureTag1 = node1.getFeatureTag();
                    String featureTag2 = node2.getFeatureTag();

                    if (featureTag1.equals(CP.TYP_ANGINA.name())) {
                        return -1;
                    } else if (featureTag2.equals(CP.TYP_ANGINA.name())) {
                        return 1;
                    }

                    if (featureTag1.equals(CP.ATYP_ANGINA.name())) {
                        return 1;
                    } else if (featureTag2.equals(CP.ATYP_ANGINA.name())) {
                        return -1;
                    }

                    if (featureTag1.equals(CP.ASYMPT.name())
                            && featureTag2.equals(CP.NON_ANGINAL.name())) {
                        return -1;
                    } else if (featureTag1.equals(CP.NON_ANGINAL.name())
                                && featureTag2.equals(CP.ASYMPT.name())) {
                        return 1;
                    }

                    return 0;
                });
                return nodes;

            // @attribute 'fbs' { t, f}
            case FBS:
                nodes.sort((node1, node2) -> {
                    String featureTag1 = node1.getFeatureTag();

                    if (featureTag1.equals(FBS.T.name())) {
                        return -1;
                    }
                    if (featureTag1.equals(FBS.F.name())) {
                        return 1;
                    }
                    return 0;
                });
                return nodes;

            // @attribute 'restecg' { left_vent_hyper, normal, st_t_wave_abnormality}
            case RESTECG:
                nodes.sort((node1, node2) -> {

                    String featureTag1 = node1.getFeatureTag();
                    String featureTag2 = node2.getFeatureTag();

                    if (featureTag1.equals(RESTECG.LEFT_VENT_HYPER.name())) {
                        return -1;
                    } else if (featureTag2.equals(RESTECG.LEFT_VENT_HYPER.name())) {
                        return 1;
                    }

                    if (featureTag1.equals(RESTECG.ST_T_WAVE_ABNORMALITY.name())) {
                        return 1;
                    } else if (featureTag2.equals(RESTECG.ST_T_WAVE_ABNORMALITY.name())) {
                        return -1;
                    }

                    return 0;
                });
                return nodes;

            // @attribute 'exang' { no, yes}
            case EXANG:
                nodes.sort((node1, node2) -> {
                    String featureTag1 = node1.getFeatureTag();

                    if (featureTag1.equals(EXANG.NO.name())) {
                        return -1;
                    }
                    if (featureTag1.equals(EXANG.YES.name())) {
                        return 1;
                    }
                    return 0;
                });
                return nodes;

            // @attribute 'slope' { up, flat, down}
            case SLOPE:
                nodes.sort((node1, node2) -> {

                    String featureTag1 = node1.getFeatureTag();
                    String featureTag2 = node2.getFeatureTag();

                    if (featureTag1.equals(Slope.UP.name())) {
                        return -1;
                    } else if (featureTag2.equals(Slope.UP.name())) {
                        return 1;
                    }

                    if (featureTag1.equals(Slope.DOWN.name())) {
                        return 1;
                    } else if (featureTag2.equals(Slope.DOWN.name())) {
                        return -1;
                    }

                    return 0;
                });
                return nodes;

            // @attribute 'thal' { fixed_defect, normal, reversable_defect}
            case THAL:
                nodes.sort((node1, node2) -> {

                    String featureTag1 = node1.getFeatureTag();
                    String featureTag2 = node2.getFeatureTag();

                    if (featureTag1.equals(THAL.FIXED_DEFECT.name())) {
                        return -1;
                    } else if (featureTag2.equals(THAL.FIXED_DEFECT.name())) {
                        return 1;
                    }

                    if (featureTag1.equals(THAL.REVERSABLE_DEFECT.name())) {
                        return 1;
                    } else if (featureTag2.equals(THAL.REVERSABLE_DEFECT.name())) {
                        return -1;
                    }

                    return 0;
                });
                return nodes;
        }

        return nodes;
    }
}
