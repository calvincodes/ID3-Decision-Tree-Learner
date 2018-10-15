package enums;

public enum CP {

    TYP_ANGINA("typ_angina"),
    ASYMPT("asympt"),
    NON_ANGINAL("non_anginal"),
    ATYP_ANGINA("atyp_angina");

    private String displayName;

    CP(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
