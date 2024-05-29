package family_tree_app.family_tree;

import java.time.LocalDate;
import java.util.List;

import family_tree_app.human.Gender;

public interface FamilyTreeEntry {
    int getAge();
    String getName();
    Gender getGender();
    List<FamilyTreeEntry> getChildren();
    FamilyTreeEntry getFather();
    FamilyTreeEntry getMother();
    LocalDate getDateOfDeath();
}