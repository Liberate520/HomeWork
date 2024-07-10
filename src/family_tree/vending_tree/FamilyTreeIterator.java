package family_tree.vending_tree;

import family_tree.human.Human;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends FamilyTree> implements Iterator<E> {
    private List<E> list;
    private int index;

    public FamilyTreeIterator(List<E> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
