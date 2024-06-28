package ru.gb.family_tree.member_comparator;

import ru.gb.family_tree.tree.FamileTreeItems;

import java.util.Comparator;

public class MemberComparatorByName<T extends FamileTreeItems> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
