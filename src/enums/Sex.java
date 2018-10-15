package enums;

public enum Sex {

    MALE("male"),
    FEMALE("female");

    private String displayName;

    Sex(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
