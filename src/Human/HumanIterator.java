package Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {

    private int index;
    private List<T> listHumans;

    public HumanIterator(List<T> listHumans) {
        this.listHumans = listHumans;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < listHumans.size();
    }

    @Override
    public T next() {
        return listHumans.get(index++);
    }
}
