package entry;

import enums.ClassLabel;
import enums.FeatureTags;
import enums.FeatureType;

import java.util.List;

public class DiabetesEntry extends InstanceEntry {

    /*
     * @relation pima_diabetes
     * @attribute 'preg' numeric
     * @attribute 'plas' numeric
     * @attribute 'pres' numeric
     * @attribute 'skin' numeric
     * @attribute 'insu' numeric
     * @attribute 'mass' numeric
     * @attribute 'pedi' numeric
     * @attribute 'age' numeric
     * @attribute 'class' { negative, positive}
     */

    private Double preg;
    private Double plas;
    private Double pres;
    private Double skin;
    private Double insu;
    private Double mass;
    private Double pedi;
    private Double age;
    private ClassLabel classLabel;

    public DiabetesEntry(List<String> featureValues) {

        this.setFeatureTags(new String[] {
                FeatureTags.PREG.name(),
                FeatureTags.PLAS.name(),
                FeatureTags.PRES.name(),
                FeatureTags.SKIN.name(),
                FeatureTags.INSU.name(),
                FeatureTags.MASS.name(),
                FeatureTags.PEDI.name(),
                FeatureTags.AGE.name(),
                FeatureTags.CLASSLABEL.name()
        });
        this.setFeatureTypes(new String[] {
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NUMERIC.name(),
                FeatureType.NOMINAL.name(), // class

        });

        this.setPreg(Double.valueOf(featureValues.get(0)));
        this.setPlas(Double.valueOf(featureValues.get(1)));
        this.setPres(Double.valueOf(featureValues.get(2)));
        this.setSkin(Double.valueOf(featureValues.get(3)));
        this.setInsu(Double.valueOf(featureValues.get(4)));
        this.setMass(Double.valueOf(featureValues.get(5)));
        this.setPedi(Double.valueOf(featureValues.get(6)));
        this.setAge(Double.valueOf(featureValues.get(7)));
        this.setClassLabel(ClassLabel.valueOf(featureValues.get(8).toUpperCase()));

        this.setFeatureValues(new String[] {
                this.preg.toString(),
                this.plas.toString(),
                this.pres.toString(),
                this.skin.toString(),
                this.insu.toString(),
                this.mass.toString(),
                this.pedi.toString(),
                this.age.toString(),
                this.classLabel.name()
        });
    }

    public Double getPreg() {
        return preg;
    }

    private void setPreg(Double preg) {
        this.preg = preg;
    }

    public Double getPlas() {
        return plas;
    }

    private void setPlas(Double plas) {
        this.plas = plas;
    }

    public Double getPres() {
        return pres;
    }

    private void setPres(Double pres) {
        this.pres = pres;
    }

    public Double getSkin() {
        return skin;
    }

    private void setSkin(Double skin) {
        this.skin = skin;
    }

    public Double getInsu() {
        return insu;
    }

    private void setInsu(Double insu) {
        this.insu = insu;
    }

    public Double getMass() {
        return mass;
    }

    private void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getPedi() {
        return pedi;
    }

    private void setPedi(Double pedi) {
        this.pedi = pedi;
    }

    public Double getAge() {
        return age;
    }

    private void setAge(Double age) {
        this.age = age;
    }

    public ClassLabel getClassLabel() {
        return classLabel;
    }

    private void setClassLabel(ClassLabel classLabel) {
        this.classLabel = classLabel;
    }

//    @Override
//    public String toString() {
//        return "DiabetesEntry{" +
//                "preg=" + preg +
//                ", plas=" + plas +
//                ", pres=" + pres +
//                ", skin=" + skin +
//                ", insu=" + insu +
//                ", mass=" + mass +
//                ", pedi=" + pedi +
//                ", age=" + age +
//                ", classLabel=" + classLabel +
//                "} " + super.toString();
//    }
}
