package Model;

import java.util.Iterator;
import java.util.List;

public class FamilyMemberIterator<T extends FamilyMember> implements Iterator<T> {
    private int curIndex;
    private List<T> members;

    public FamilyMemberIterator(List<T> members) {
        this.members = members;
    }

    public boolean hasNext() {
        return members.size() > curIndex;
    }

    public T next() {
        return members.get(curIndex++);
    }
}