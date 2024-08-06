package Family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

// import Family_tree.human.Human;

public class HumanIterator<T> implements Iterator<T>{
    private int currentId;
    private List<T> tree;

    public HumanIterator(List<T> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return currentId < tree.size();
    }

    @Override
    public T next() {
        return tree.get(currentId++);
    }
}
