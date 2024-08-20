package GB_FamilyTree.Family_Tree.Family_Tree;

import GB_FamilyTree.Family_Tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    //Конструктор

    public FamilyTreeIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
