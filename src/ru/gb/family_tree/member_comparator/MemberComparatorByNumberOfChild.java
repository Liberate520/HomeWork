package ru.gb.family_tree.member_comparator;

import ru.gb.family_tree.tree.FamileTreeItems;

import java.util.Comparator;

public class MemberComparatorByNumberOfChild<T extends FamileTreeItems> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChild().size(), o1.getChild().size());
    }
}
