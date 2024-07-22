package com.github.pahanuchek.family_tree.human.comparators;

import com.github.pahanuchek.family_tree.family_tree.ItemUser;
import com.github.pahanuchek.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends ItemUser> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
