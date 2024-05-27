package family_TREE.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode<T>> implements Iterator<T> {
    private final List<T> list;
    private int index;

    public FamilyTreeIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    public boolean hasNext() {return  index < list.size();}

    public T next() {return  list.get(index++);}
}
