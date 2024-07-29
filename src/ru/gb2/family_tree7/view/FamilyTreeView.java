package ru.gb2.family_tree7.view;

import ru.gb2.family_tree7.model.human.Human;

import java.util.List;

public interface FamilyTreeView {
    void showFamilyMembers(List<Human> members);

    void showFamilyMembers(boolean add);
}
