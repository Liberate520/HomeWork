package Model.FamilyTree;

import Model.Human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<E> extends Serializable {
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getParents();

    int getAgeInfo();
    List<E> getChildren();
    void setChildren(E human);
    void setId(int id);
    int getId();
    E getSpouse();
    void setSpouse(E spouse);
}
