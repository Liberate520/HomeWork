package FamilyTree;

import java.util.Comparator;

public class LeafComparatorByAge<E extends LeafFamilyTree<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
