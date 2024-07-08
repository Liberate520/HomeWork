package ru.gb.family_tree.model.tree.interfaces;

import java.util.List;

public interface FamileTreeItems<T> {
    int getAge();
    String getName();
    List<T> getChild();
}
