package model.FamilyTree;
import model.human.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterator <E>implements Iterator<E> {
    private int index;
    private List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.index = 0;
        this.humanList = humanList;
    }


    @Override
    public boolean hasNext() {
        return index<humanList.size();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("No more elements");
        }
        return humanList.get(index++);

    }
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}
