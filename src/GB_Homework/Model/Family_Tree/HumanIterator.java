package GB_Homework.Model.Family_Tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {
    private int currentId;
    private List<T> humans;

    public HumanIterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > currentId;
    }

    @Override
    public T next() {
        return humans.get(currentId++);
    }
}
