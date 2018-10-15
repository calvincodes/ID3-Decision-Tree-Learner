package enums;

public enum RESTECG {

    LEFT_VENT_HYPER("left_vent_hyper"),
    NORMAL("normal"),
    ST_T_WAVE_ABNORMALITY("st_t_wave_abnormality");

    private String displayName;

    RESTECG(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
