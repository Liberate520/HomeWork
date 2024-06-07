package src.family_tree.Iterator;

import src.family_tree.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> list;
    private int i;

    public FamilyTreeIterator(List<Human> list){
        this.list = list;
        i = 0;
    }


    @Override
    public boolean hasNext() {
        return i < list.size();
    }

    @Override
    public Human next() {
        return list.get(i++);
    }
}
