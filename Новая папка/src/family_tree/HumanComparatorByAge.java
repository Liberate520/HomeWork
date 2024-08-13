package family_tree;

import family_tree.model.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<E extends ItemFamilyTree> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getAge()-o2.getAge();
    }
}
