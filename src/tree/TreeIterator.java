package tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E extends TreeItem<E>> implements Iterator <E>  {
    private int index;
    private List<E> allObjects;

    public TreeIterator(List<E> allObjects) {

        this.allObjects = allObjects;
    }

    @Override
    public boolean hasNext() {

        return index < allObjects.size();
    }

    @Override
    public E next() {

        return allObjects.get(index++);
    }


}
