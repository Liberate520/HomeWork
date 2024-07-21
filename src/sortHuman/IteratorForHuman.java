package sortHuman;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class IteratorForHuman implements Iterator<Human>{
    private int index;
    private final List<Human> humanList;

    public IteratorForHuman(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
