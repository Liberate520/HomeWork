package src.familyTree;

import src.human.Human;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends FamilyTreeElement> implements Iterator<E> {
    private int index = 0;
    private List<E> humanList;

    public FamilyTreeIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}