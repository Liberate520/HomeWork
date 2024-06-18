package ru.gb.family_tree.model.human;


import ru.gb.family_tree.model.family_tree.FamilyItem;

import java.util.Comparator;

public class HumanComparatorByName<E extends FamilyItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2){
        return o1.getName().compareTo(o2.getName());
    }
}
