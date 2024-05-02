package model.family_tree;

import model.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyItem<T> extends Serializable {

    String getName();
    int getAge();
    T getMother();
    T getFather();
    LocalDate getDob();
    Gender getGender();
    List<T> getChildren();
}
