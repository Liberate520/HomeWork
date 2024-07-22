package com.github.pahanuchek.family_tree.family_tree;

import java.util.List;

public interface ItemUser<T> {
    int getId();
    T getFather();
    T getMother();
    List<T> getChildren();
    boolean addParents(T t);
    boolean addChildren(T t);
    int getAge();
    String getName();
}
