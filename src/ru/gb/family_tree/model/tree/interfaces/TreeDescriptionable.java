package ru.gb.family_tree.model.tree.interfaces;

import java.util.List;

public interface TreeDescriptionable<T>{
    String getFullTree(List<T> tree);
}
