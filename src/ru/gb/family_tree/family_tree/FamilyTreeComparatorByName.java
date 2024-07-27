package ru.gb.family_tree.family_tree;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends TreeNode<T>> implements Comparator<T> {

    //    @Override
//    public int compare(T o1, T o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0; // оба объекта равны
        }
        if (o1 == null) {
            return -1; // null меньше любого объекта
        }
        if (o2 == null) {
            return 1; // любой объект больше null
        }

        String name1 = o1.getName();
        String name2 = o2.getName();

        if (name1 == null && name2 == null) {
            return 0; // оба имени равны
        }
        if (name1 == null) {
            return -1; // null меньше любого имени
        }
        if (name2 == null) {
            return 1; // любое имя больше null
        }

        return name1.compareTo(name2); // Сравнение имен
    }
}
