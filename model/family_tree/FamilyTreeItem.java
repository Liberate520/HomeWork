package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import model.human.Gender;

public interface FamilyTreeItem<T> extends Serializable, Comparable<T> {
    String getFirstName();

    String getLastName();

    LocalDate getBirthDate();

    public Gender getGender();

    int getAge();

    long getId();

    void setId(long ID);

    List<T> getParents();

    List<T> getChildren();

    void setChildren(List<T> children);

    boolean addChild(T child);

    boolean addParent(T parent);

    T getSpouse();

    void setSpouse(T spouse);

    String getInfo();
}
