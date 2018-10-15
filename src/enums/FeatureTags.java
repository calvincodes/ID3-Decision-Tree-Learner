package enums;

public enum FeatureTags {

    AGE,
    SEX,
    CP,
    TRESTBPS,
    CHOL,
    FBS,
    RESTECG,
    THALACH,
    EXANG,
    OLDPEAK,
    SLOPE,
    CA,
    THAL,

    PREG,
    PLAS,
    PRES,
    SKIN,
    INSU,
    MASS,
    PEDI,
    // AGE,

    CLASSLABEL,

    GENERIC;

    public static FeatureTags getValueOf(String value) {
        try {
            return FeatureTags.valueOf(value);
        } catch (Exception ex) {
            return FeatureTags.GENERIC;
        }
    }
}
