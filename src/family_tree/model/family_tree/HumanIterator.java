package family_tree.model.family_tree;

import java.util.List;
import java.util.Iterator;

public class HumanIterator<E extends FamilyTreeItem> implements Iterator<E>{
    private List<E> humanList;
    private int index = 0;

    public HumanIterator(List<E> humanArrayList) {
        this.humanList = humanArrayList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() { return humanList.get(index++);
    }
}
