package FamilyTree.Comparator;

import FamilyTree.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human> {
    private List<Human> humanList;
    private int index;

    public TreeIterator(List<Human> humanList) {
        this.humanList = humanList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
