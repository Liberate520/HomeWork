package Humans;

import java.util.Comparator;

import FamilyTree.ItemFamilyTree;

public class HumanComparatorByName<U extends ItemFamilyTree> implements Comparator<U>{

    @Override
    public int compare(U o1, U o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
