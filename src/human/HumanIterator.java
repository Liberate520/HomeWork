package human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curIndex;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > curIndex;
    }

    @Override
    public Human next() {
        return humans.get(curIndex++);
    }
}