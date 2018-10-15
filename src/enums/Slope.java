package enums;

public enum Slope {

    UP("up"),
    FLAT("flat"),
    DOWN("down");

    private String displayName;

    Slope(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
