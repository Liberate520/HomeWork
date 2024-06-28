package ru.gb.family_tree.member_comparator;

import ru.gb.family_tree.tree.FamileTreeItems;

import java.util.Comparator;

public class MemberComparatorByAge<T extends FamileTreeItems> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}
