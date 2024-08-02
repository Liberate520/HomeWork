package ru.gb.family_tree.model.FT;

import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.builder.HumanBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>, Serializable {
    void setParents(T mother, T father);
    void addChild(T child);
    void setMother(T mother);
    void setFather(T father);

    String getName();
    int getAge();
    LocalDate getBirthDate();
    List<T> getChildren();

    long getId();

    Gender getGender();

    <T extends FamilyTreeItem<T>> T getMother();

    <T extends FamilyTreeItem<T>> T getFather();

}
