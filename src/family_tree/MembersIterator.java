package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class MembersIterator implements Iterator<Human> {

    private int index;
    private final List<Human> familyMembers;

    public MembersIterator(List<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public Human next() {
        return familyMembers.get(index++);
    }

}
