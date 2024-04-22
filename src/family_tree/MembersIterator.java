package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class MembersIterator<T extends FamilyTreeElement> implements Iterator<T> {

    private int index;
    private final List<T> familyMembers;

    public MembersIterator(List<T> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public T next() {
        return familyMembers.get(index++);
    }

}
