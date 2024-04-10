package family_tree.tree;

import family_tree.person.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator<T extends Human> implements Iterator<T> {
    private ArrayList<T> humanList;
    private int index;

    public HumanIterator(ArrayList<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
