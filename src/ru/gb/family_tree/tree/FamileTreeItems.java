package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.List;

public interface FamileTreeItems<T> {
    int getAge();
    String getName();
    List<T> getChild();
}
