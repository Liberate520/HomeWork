package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends FamilyTreeItem<T>> implements Iterator<T> {
    private int index;
    private List<T> list;

    public FamilyTreeIterator(List<T> list){
        index = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index > list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
