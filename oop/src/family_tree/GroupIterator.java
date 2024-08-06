package family_tree;

import man.Man;

import java.util.Iterator;
import java.util.List;

public class GroupIterator<E> implements Iterator<E> {
    private int index;
    private List<E> itemList;
    public GroupIterator(List<E> manList){
        this.itemList = manList;
    }

    @Override
    public boolean hasNext() {
        return index< itemList.size();
    }

    @Override
    public E next() {
        return itemList.get(index++);
    }
}
