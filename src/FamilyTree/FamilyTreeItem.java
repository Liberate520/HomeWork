package FamilyTree;

import Human.Gender;
import Human.Human;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface FamilyTreeItem<E> {
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getParents();

    int getAgeInfo();
    List<E> getChildren();
    void setChildren(E human);
    void setId(int id);
    E getSpouse();
    void setSpouse(E spouse);
}
