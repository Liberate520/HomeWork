package ru.gb.family_tree.interfaces;

import java.io.Serializable;
import java.util.List;

public interface HasRelations<T> extends Serializable {
    List<T> getChildren();
    List<T> getParents();
    void addChild(T child);
    void addParent(T parent);
}
