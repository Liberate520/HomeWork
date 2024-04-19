package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;


public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}

//-------------------------------------------------------------
