package Model;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curIndex;
    private List<Human> human;

    public HumanIterator(List<Human> human) {
        this.human = human;
    }

    public boolean hasNext() {
        return human.size() > curIndex;
    }

    public Human next() {
        return human.get(curIndex++);
    }

}
