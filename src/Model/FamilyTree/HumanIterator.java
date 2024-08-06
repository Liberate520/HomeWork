package src.Model.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator <E> implements Iterator <E> {
    private int CurrentID;
    private List<E> members;

    public HumanIterator(List<E> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return members.size() > CurrentID;
    }

    @Override
    public E next() {
       return members.get(CurrentID++);
    }
}
