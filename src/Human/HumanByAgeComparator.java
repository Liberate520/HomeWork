package Human;

import FamilyTree.ItemFamilyTree;

import java.util.Comparator;

public class HumanByAgeComparator <E extends ItemFamilyTree<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDateBrith().compareTo(o2.getDateBrith());
    }
}
