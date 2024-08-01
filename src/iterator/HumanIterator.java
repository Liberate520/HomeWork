package iterator;

import human.Human;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> { // класс для настройи итератора
    private int currentID;
    private List<T> humans;

    public HumanIterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > currentID;
    }

    @Override
    public T next() {
        return humans.get(currentID++);
    }
}
