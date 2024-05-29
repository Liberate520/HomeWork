package family_tree_app.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import family_tree_app.human.Gender;

public interface FamilyTreeEntry extends Serializable {
    int getAge();
    String getName();
    Gender getGender();
    List<?> getChildren();
    FamilyTreeEntry getFather();
    FamilyTreeEntry getMother();
    LocalDate getDateOfDeath();
}