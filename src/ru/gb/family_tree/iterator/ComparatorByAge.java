package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;


public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}

//-------------------------------------------------------------
