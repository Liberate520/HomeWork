package model.family_tree.Iterators;

import java.util.Iterator;
import java.util.List;

public class MembersIterator<E> implements Iterator<E> {

    private int index;
    private final List<E> familyMembers;

    public MembersIterator(List<E> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public E next() {
        return familyMembers.get(index++);
    }

}
