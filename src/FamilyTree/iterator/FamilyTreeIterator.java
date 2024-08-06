package FamilyTree.iterator;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E> implements Iterator<E> {
    private List<E> members;
    private int currentIndex;

    public FamilyTreeIterator(List<E> members) {
        this.members = members;
//        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < members.size();
    }

    @Override
    public E next() {
        return members.get(currentIndex++);
    }
}