package ru.gb.family_tree.human;

import ru.gb.family_tree.tree.FamileTreeItems;

import java.util.Comparator;

/*

 */
public enum Gender {
    M, F;

    public static class MemberComparatorByName<T extends FamileTreeItems> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
