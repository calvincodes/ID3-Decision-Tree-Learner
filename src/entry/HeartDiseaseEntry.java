package entry;

import enums.CP;
import enums.ClassLabel;
import enums.EXANG;
import enums.FBS;
import enums.FeatureTags;
import enums.FeatureType;
import enums.RESTECG;
import enums.Sex;
import enums.Slope;
import enums.THAL;

import java.util.List;

public class HeartDiseaseEntry extends InstanceEntry {

    /*
     * @relation cleveland-14-heart-disease
     * @attribute 'age' real
     * @attribute 'sex' { female, male}
     * @attribute 'cp' { typ_angina, asympt, non_anginal, atyp_angina}
     * @attribute 'trestbps' real
     * @attribute 'chol' real
     * @attribute 'fbs' { t, f}
     * @attribute 'restecg' { left_vent_hyper, normal, st_t_wave_abnormality}
     * @attribute 'thalach' real
     * @attribute 'exang' { no, yes}
     * @attribute 'oldpeak' real
     * @attribute 'slope' { up, flat, down}
     * @attribute 'ca' real
     * @attribute 'thal' { fixed_defect, normal, reversable_defect}
     * @attribute 'class' { negative, positive}
     */

    private Double age;
    private Sex sex;
    private CP cp;
    private Double trestbps;
    private Double chol;
    private FBS fbs;
    private RESTECG restecg;
    private Double thalach;
    private EXANG exang;
    private Double oldpeak;
    private Slope slope;
    private Double ca;
    private THAL thal;
    private ClassLabel classLabel;

    public HeartDiseaseEntry(List<String> featureValues) {

        this.setFeatureTags(new String[] {
                FeatureTags.AGE.name(),
                FeatureTags.SEX.name(),
                FeatureTags.CP.name(),
                FeatureTags.TRESTBPS.name(),
                FeatureTags.CHOL.name(),
                FeatureTags.FBS.name(),
                FeatureTags.RESTECG.name(),
                FeatureTags.THALACH.name(),
                FeatureTags.EXANG.name(),
                FeatureTags.OLDPEAK.name(),
                FeatureTags.SLOPE.name(),
                FeatureTags.CA.name(),
                FeatureTags.THAL.name(),
                FeatureTags.CLASSLABEL.name()
        });
        this.setFeatureTypes(new String[] {
                FeatureType.NUMERIC.name(), // age
                FeatureType.NOMINAL.name(), // sex
                FeatureType.NOMINAL.name(), // cp
                FeatureType.NUMERIC.name(), // trestbps
                FeatureType.NUMERIC.name(), // chol
                FeatureType.NOMINAL.name(), // fbs
                FeatureType.NOMINAL.name(), // restecg
                FeatureType.NUMERIC.name(), // thalach
                FeatureType.NOMINAL.name(), // exang
                FeatureType.NUMERIC.name(), // oldpeak
                FeatureType.NOMINAL.name(), // slope
                FeatureType.NUMERIC.name(), // ca
                FeatureType.NOMINAL.name(), // thal
                FeatureType.NOMINAL.name(), // class

        });

        this.setAge(Double.valueOf(featureValues.get(0)));
        this.setSex(Sex.valueOf(featureValues.get(1).toUpperCase()));
        this.setCp(CP.valueOf(featureValues.get(2).toUpperCase()));
        this.setTrestbps(Double.valueOf(featureValues.get(3)));
        this.setChol(Double.valueOf(featureValues.get(4)));
        this.setFbs(FBS.valueOf(featureValues.get(5).toUpperCase()));
        this.setRestecg(RESTECG.valueOf(featureValues.get(6).toUpperCase()));
        this.setThalach(Double.valueOf(featureValues.get(7)));
        this.setExang(EXANG.valueOf(featureValues.get(8).toUpperCase()));
        this.setOldpeak(Double.valueOf(featureValues.get(9)));
        this.setSlope(Slope.valueOf(featureValues.get(10).toUpperCase()));
        this.setCa(Double.valueOf(featureValues.get(11)));
        this.setThal(THAL.valueOf(featureValues.get(12).toUpperCase()));
        this.setClassLabel(ClassLabel.valueOf(featureValues.get(13).toUpperCase()));

        this.setFeatureValues(new String[] {
                this.age.toString(),
                this.sex.name(),
                this.cp.name(),
                this.trestbps.toString(),
                this.chol.toString(),
                this.fbs.name(),
                this.restecg.name(),
                this.thalach.toString(),
                this.exang.name(),
                this.oldpeak.toString(),
                this.slope.name(),
                this.ca.toString(),
                this.thal.name(),
                this.classLabel.name()
        });
    }

    public Double getAge() {
        return age;
    }

    private void setAge(Double age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    private void setSex(Sex sex) {
        this.sex = sex;
    }

    public CP getCp() {
        return cp;
    }

    private void setCp(CP cp) {
        this.cp = cp;
    }

    public Double getTrestbps() {
        return trestbps;
    }

    private void setTrestbps(Double trestbps) {
        this.trestbps = trestbps;
    }

    public Double getChol() {
        return chol;
    }

    private void setChol(Double chol) {
        this.chol = chol;
    }

    public FBS getFbs() {
        return fbs;
    }

    private void setFbs(FBS fbs) {
        this.fbs = fbs;
    }

    public RESTECG getRestecg() {
        return restecg;
    }

    private void setRestecg(RESTECG restecg) {
        this.restecg = restecg;
    }

    public Double getThalach() {
        return thalach;
    }

    private void setThalach(Double thalach) {
        this.thalach = thalach;
    }

    public EXANG getExang() {
        return exang;
    }

    private void setExang(EXANG exang) {
        this.exang = exang;
    }

    public Double getOldpeak() {
        return oldpeak;
    }

    private void setOldpeak(Double oldpeak) {
        this.oldpeak = oldpeak;
    }

    public Slope getSlope() {
        return slope;
    }

    private void setSlope(Slope slope) {
        this.slope = slope;
    }

    public Double getCa() {
        return ca;
    }

    private void setCa(Double ca) {
        this.ca = ca;
    }

    public THAL getThal() {
        return thal;
    }

    private void setThal(THAL thal) {
        this.thal = thal;
    }

    public ClassLabel getClassLabel() {
        return classLabel;
    }

    private void setClassLabel(ClassLabel classLabel) {
        this.classLabel = classLabel;
    }

//    @Override
//    public String toString() {
//        return "HeartDiseaseEntry{" +
//                "age=" + age +
//                ", sex=" + sex +
//                ", cp=" + cp +
//                ", trestbps=" + trestbps +
//                ", chol=" + chol +
//                ", fbs=" + fbs +
//                ", restecg=" + restecg +
//                ", thalach=" + thalach +
//                ", exang=" + exang +
//                ", oldpeak=" + oldpeak +
//                ", slope=" + slope +
//                ", ca=" + ca +
//                ", thal=" + thal +
//                ", classLabel=" + classLabel +
//                "} " + super.toString();
//    }
}
