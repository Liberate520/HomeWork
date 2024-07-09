package ru.gb.family_tree.model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<E> {
    long getId();
    void setId(long id);
    String getName();
    E getSpouse();
    void setSpouse(E spouse);
    List<E> getParents();
    List<E> getChildrens();
    void addParent(E parent);
    void addChild(E child);

    LocalDate getBirthDate();
}