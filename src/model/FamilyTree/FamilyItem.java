package model.FamilyTree;

import model.Gender.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyItem extends Serializable {
    int getIdFamilyItem();
    int getAge();
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    Gender getGender();
    String getChildren();
    String getParents();

}
