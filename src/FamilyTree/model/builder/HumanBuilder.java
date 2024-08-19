package FamilyTree.model.builder;

import FamilyTree.model.familyTree.Gender;
import FamilyTree.model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genId;

    public Human build(String name, LocalDate birthDate, Gender gender, String occupation,
                       String nationality, String placeOfBirth, Human father, Human mother) {
//        System.out.println("HB_build1_genId: " + genId);
//        System.out.println("HB_build1_Pres_aH_name: " + name);
//        System.out.println("HB_build1_Pres_aH_birthDate: " + birthDate);
//        System.out.println("HB_build1_Pres_aH_gender: " + gender);

        return new Human(genId++, name, birthDate, null, gender, occupation, nationality, placeOfBirth, father, mother);
    }

    public Human build(String name, LocalDate birthDate, Gender gender) {
//        System.out.println("HB_build2_genId: " + genId);
//        System.out.println("HB_build2_Pres_aH_name: " + name);
//        System.out.println("HB_build2_Pres_aH_birthDate: " + birthDate);
//        System.out.println("HB_build2_Pres_aH_gender: " + gender);

        return new Human(genId++, name, birthDate, null, gender, null, null, null, null, null);
    }

    public Human build(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        return new Human(genId++, name, birthDate, null, gender, null, null, null, father, mother);
    }

}
