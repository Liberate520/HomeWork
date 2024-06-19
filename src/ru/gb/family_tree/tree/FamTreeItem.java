package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Gender;

import java.time.LocalDate;

public interface FamTreeItem<T> {
    LocalDate getDob();
    LocalDate getDod();
    long getCurrentId();
    long getId();
    Gender getGender();
    String getFirstName();

    void setId(long currentId);

    void setCurrentId();
}
