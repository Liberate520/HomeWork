package family_tree.human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator {
    List<Human> humanList;
    int index;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size()>index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);

    }
}
