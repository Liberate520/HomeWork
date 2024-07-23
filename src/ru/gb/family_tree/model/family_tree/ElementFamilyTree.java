package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface ElementFamilyTree<E> extends Comparable<E> {


    LocalDate getBirthDate();
    String getName();
    String getChildrenInfo();
    int getAge();
}
