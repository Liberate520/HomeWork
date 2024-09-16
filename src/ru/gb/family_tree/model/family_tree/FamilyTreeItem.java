package ru.gb.family_tree.model.family_tree;

import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Comparable<T> {
    int getId();
    LocalDate getBirthDate();

}
