package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem<E> extends Serializable {
    int getAge();
    String getName();
    int getId();
    LocalDate getBirthDate();
    E getSpouse();
    void setSpouse(E human);
    boolean addChild(E child);
    boolean addParent(E parent);
}
