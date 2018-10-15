package enums;

public enum Operator {

    LESS_THAN_EQUAL("<="),
    GREATER(">"),
    EQUAL("=");

    private String displayName;

    Operator(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
