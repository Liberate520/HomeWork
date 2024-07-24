package FamilyTree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curIndex;
    private List<Human> family;

    public HumanIterator(List<Human> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return family.size() > curIndex;
    }

    @Override
    public Human next() {
        return family.get(curIndex++);
    }
}

