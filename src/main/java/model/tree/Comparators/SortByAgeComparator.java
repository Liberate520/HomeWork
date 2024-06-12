package model.tree.Comparators;


import model.tree.interfaces.TreeCreaturable;

import java.util.Comparator;

public class SortByAgeComparator<E extends TreeCreaturable<E>> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o2.getAge() - o1.getAge();
    }
}
