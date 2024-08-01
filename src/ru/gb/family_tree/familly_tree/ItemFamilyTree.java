package ru.gb.family_tree.familly_tree;

import java.time.LocalDate;

public interface ItemFamilyTree {
    String getName();
    LocalDate getBirthDate();
    void setId(long l);
    long getId();
}
