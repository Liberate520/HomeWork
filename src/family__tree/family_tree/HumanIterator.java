package family__tree.family_tree;

import family__tree.human.Human;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class HumanIterator implements Iterator<Human> {
    private List<Human> humans;

    private int currentPosition;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < humans.size();
    }

    @Override
    public Human next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return humans.get(currentPosition++);
    }
}
