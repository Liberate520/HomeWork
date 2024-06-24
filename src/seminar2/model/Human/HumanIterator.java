package seminar2.model.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {

    private final List<T> humanList;
    private int index;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
