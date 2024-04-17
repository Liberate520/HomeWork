package family_tree.model.family_tree;

import java.util.List;
import java.util.Iterator;

public class FamilyTreeIterator<T extends TreeClass<T>> implements Iterator<T>{
    private List<T> list;
    private int index;

    public FamilyTreeIterator(List<T> list) { this.list = list;
            this.index = 0;}
    

    @Override
    public boolean hasNext() { return index < list.size();}

    @Override
    public T next() { return list.get(index++);}
}
