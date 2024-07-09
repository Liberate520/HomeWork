package FamilyTree.familyTree;

import FamilyTree.human.Human;

import java.util.Iterator;
import java.util.List;

public class ItemIterator<E extends ElementFamilyTree<E>> implements Iterator<E> {

    private int curId;
    private final List<E> itemList;

    public ItemIterator(List<E> humanList) {
        this.itemList = humanList;
    }

    @Override
    public boolean hasNext() {
        return itemList.size() > curId;
    }

    @Override
    public E next() {
        return itemList.get(curId++);
    }
}
