package ru.gb.family_tree.FT;

import ru.gb.family_tree.Human.Gender;
import ru.gb.family_tree.Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>{
    void setParents(T mother, T father);
    void addChild(T child);
    void setMother(T mother);
    void setFather(T father);

    String getName();
    int getAge();
    LocalDate getBirthDate();
    List<T> getChildren();
}
