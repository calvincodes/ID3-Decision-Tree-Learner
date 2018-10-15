package enums;

public enum ClassLabel {

    POSITIVE("positive"),
    NEGATIVE("negative");

    private String displayName;

    ClassLabel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
