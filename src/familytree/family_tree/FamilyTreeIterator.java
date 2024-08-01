package familytree.family_tree;

import java.util.Iterator;
import java.util.List;
import familytree.human.Human;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private List<T> humans;
    private int index;

    public FamilyTreeIterator (List<T> humans){
        this.humans = humans;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public T next() {
        return humans.get(index++);
    }
}