package FamilyTree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> list;
    private int index;
    public FamilyTreeIterator(List<Human> list){
        this.list = list;
        index = 0;
    }
    public boolean hasNext() {return index < list.size(); }
    public Human next() {return list.get(index++); }
}
