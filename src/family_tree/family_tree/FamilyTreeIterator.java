package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int currentIndex;
    private List<Human> humans;

    public FamilyTreeIterator(List<Human> humans) {
        this.humans = humans;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > currentIndex;
    }

    @Override
    public Human next() {
        return humans.get(currentIndex++);
    }
}
