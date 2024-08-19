package tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {

    private List<Human> list;
    private int ind;

    public FamilyTreeIterator(List<Human> list){
        this.list = list;
        ind = 0;
    }

    @Override
    public boolean hasNext() {
        return ind<list.size();
    }

    @Override
    public Human next() {
        return list.get(ind++);
    }
}
