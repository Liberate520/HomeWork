package Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator {
    private int currentIndex;
    private List<Human> humans;

    public HumanIterator(List<Human> humans){
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size()> currentIndex;
    }

    @Override
    public Object next() {
        return humans.get(currentIndex++);
    }
}
