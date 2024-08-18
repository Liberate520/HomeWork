package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> list;

    public FamilyTreeIterator(List<Human> list){
        index = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index > list.size();
    }

    @Override
    public Human next() {
        return list.get(index++);
    }
}
