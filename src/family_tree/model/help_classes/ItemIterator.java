package family_tree.model.help_classes;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemIterator<T> implements Iterator<T> {
    private int current_index;
    private ArrayList<T> fTree;

    public ItemIterator(ArrayList<T> fTree) {
        this.fTree = fTree;
    }

    @Override
    public boolean hasNext() {
        return fTree.size() > current_index;
    }

    @Override
    public T next() {
        return fTree.get(current_index++);
    }
}