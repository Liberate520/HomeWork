package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Human;

import java.util.List;

public interface FamilyItem {
    String getName();
    int getAge();
    List<Human> getChildren();
    List<Human> getParents();

}
