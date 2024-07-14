package familyTreeSrc;

import person.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int currentId;
    private List<Human> people;

    public FamilyTreeIterator(int currentId, List<Human> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return currentId < people.size();
    }

    @Override
    public Human next() {
        return people.get(currentId++);
    }
}
