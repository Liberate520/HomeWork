package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface ElementFamilyTree<E> extends Comparable<E> {
    void setChildren(List<E> children);
    void addChild(E child);
    void addParents(E parent);
    LocalDate getBirthDate();
    long getId();
    void setId(long id);
    String getName();
    Gender getGender();
    List<E> getChildren();
    String getMotherInfo();
    String getFatherInfo();
    StringBuilder getChildrenInfo();
    int getAge();
    String getBasicInfo();
}
