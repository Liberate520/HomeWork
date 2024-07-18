package Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int currentIndex;
    private List<E> humans;

    public HumanIterator(List<E> humans){
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size()> currentIndex;
    }

    @Override
    public E next() {
        return humans.get(currentIndex++);
    }
}
