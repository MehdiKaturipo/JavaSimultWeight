package ma.MyWeight.modéle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor

public class Weight {
    private Long id;
    private String name;
    private String sexe;
    private Double age;
    private double poids;
    private double height;
    private double bmi;
    private String description;

    public String  getDescription() {

        if (bmi < 18.5) {
            description="Vous êtes en sous-poids"   ;
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            description="Vous êtes en poids normal"   ;
        } else if (bmi >= 25 && bmi <= 29.9) {
            description="Vous êtes en surpoids"   ;
        } else if (bmi >= 30 && bmi <= 34.9) {
            description="Vous êtes en obésité de classe 1"   ;
        } else if (bmi >= 35 && bmi <= 39.9) {
            description="Vous êtes en obésité de classe 2"   ;
        } else if (bmi >= 40) {
            description="Vous êtes en obésité de classe 3"   ;
        } else {
            description="Vous êtes en surpoids"   ;
        }
        return description;
    }

    @Override
    public String toString() {
        var weightStr ="= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =\n";
        weightStr += "=>  N°                                             : " +getId() +"\n";
        weightStr += "=> Name                                            : " +getName()+"\n";
        weightStr += "=>  Sexe                                           : " +getSexe() +"\n";
        weightStr += "=>  Age                                            : " +getAge() +" ans"+"\n";
        weightStr += "---------------------------------------------------------------------------------\n";
        weightStr += "=> Height                                          : " + getHeight() +" Cm"+" \n";
        weightStr += "=> Weight                                          : " + getPoids() +" Kg"+" \n";
        weightStr += "--------------------------------------------------------------------------------\n";
        weightStr += "=> BMI                                             : "
                + (getBmi() == 0.0 ? "NON-CALCULE": getBmi()+" Cm/Kg") +"\n";
        weightStr += "=> Description                                     : " +getDescription() +" \n";
        weightStr +="= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =\n";
        return  weightStr;

    }

}
