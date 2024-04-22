package family_tree.model.tree;

import family_tree.model.person.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator<T extends TreeNode<T>> implements Iterator<T> {
    private ArrayList<T> unitsList;
    private int index;

    public HumanIterator(ArrayList<T> unitsList) {
        this.unitsList = unitsList;
    }

    @Override
    public boolean hasNext() {
        return index < unitsList.size();
    }

    @Override
    public T next() {
        return unitsList.get(index++);
    }
}
