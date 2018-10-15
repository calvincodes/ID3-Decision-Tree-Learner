package enums;

public enum FBS {

    T("t"),
    F("f");

    private String displayName;

    FBS(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
