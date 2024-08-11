package family_tree;

import java.util.Iterator;
import java.util.List;

import human.Human;

public class HumanIterator implements Iterator<Human> {
    private int curIndex;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
        curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return curIndex < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(curIndex++);
    }

}
