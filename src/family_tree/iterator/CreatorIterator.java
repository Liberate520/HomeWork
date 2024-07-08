package family_tree.iterator;

import java.util.Iterator;
import java.util.List;

public class CreatorIterator<T> implements Iterator<T> {
    private int currentId;
    private List<T> creatorList;

    public CreatorIterator(List<T> creatorList) {
        this.creatorList = creatorList;
    }

    @Override
    public boolean hasNext() {
        return creatorList.size() > currentId;
    }

    @Override
    public T next() {
        return creatorList.get(currentId++);
    }
}
