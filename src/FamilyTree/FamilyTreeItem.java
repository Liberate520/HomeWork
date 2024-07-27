package FamilyTree;

import Human.Gender;
import Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem {
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<Human> getParents();
}
