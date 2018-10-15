package enums;

public enum THAL {

    FIXED_DEFECT("fixed_defect"),
    NORMAL("normal"),
    REVERSABLE_DEFECT("reversable_defect");

    private String displayName;

    THAL(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
