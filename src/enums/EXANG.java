package enums;

public enum EXANG {

    YES("yes"),
    NO("no");

    private String displayName;

    EXANG(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
