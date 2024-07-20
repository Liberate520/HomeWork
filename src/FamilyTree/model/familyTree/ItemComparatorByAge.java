package FamilyTree.model.familyTree;

import FamilyTree.model.element.ElementFamilyTree;

import java.util.Comparator;

public class ItemComparatorByAge<T extends ElementFamilyTree<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
