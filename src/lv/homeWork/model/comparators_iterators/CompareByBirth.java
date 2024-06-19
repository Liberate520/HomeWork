package lv.homeWork.model.comparators_iterators;

import lv.homeWork.model.objects.TreeNode;

import java.util.Comparator;

public class CompareByBirth<E extends TreeNode<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
