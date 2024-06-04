package ru.gb.family_tree.tree;

import ru.gb.family_tree.humans.Human;

import java.util.Comparator;

public class FamilyTreeComporatorByGender<T extends TreeNode<T>>  implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}