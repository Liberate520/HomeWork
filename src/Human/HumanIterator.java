package Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index;
    private List<Human> listHumans;

    public HumanIterator(List<Human> listHumans) {
        this.listHumans = listHumans;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < listHumans.size();
    }

    @Override
    public Human next() {
        return listHumans.get(index++);
    }
}
