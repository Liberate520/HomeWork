package Model.FamilyTree;

import Model.Human.Gender;
import Model.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<E> extends Serializable {
    void setId(int id);
    int getId();
    void setChildren(E human);
    Gender getGender();
    void setMother(E mother);
    void setFather(E mother);
    E getSpouse();
    void setSpouse(E spouse);
    String getName();
    int getAgeInfo();
    List<E> getChildren();
    LocalDate getBirthDate();
}
