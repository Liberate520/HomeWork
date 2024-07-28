package Family_tree.family_tree;

import java.util.Iterator;
import java.util.List;

import Family_tree.human.Human;

public class HumanIterator implements Iterator<Human>{
    private int currentId;
    private List<Human> tree;

    public HumanIterator(List<Human> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return currentId < tree.size();
    }

    @Override
    public Human next() {
        return tree.get(currentId++);
    }
}
