package ru.gb.family_tree.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable, Comparable<T> {
    void setId(int id);
    void setSpouse(T spouse);
    int getId();
    String getName();
    LocalDate getBirthDay();
    int getAge();
    T getFather();
    T getMother();
    T getSpouse();
    List<T> getChildren();
    String getChildrenInfo();
    boolean addChild(T child);
    boolean addParent(T parent);
    List<T> getParents();
}
