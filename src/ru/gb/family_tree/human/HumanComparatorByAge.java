package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyItem;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
