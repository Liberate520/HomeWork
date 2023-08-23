package Model.FamilyTree.Comparator;

import Model.FamilyTree.FamilyTree.EntityItem;

import java.util.Comparator;

public class SortByAge<E extends EntityItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
