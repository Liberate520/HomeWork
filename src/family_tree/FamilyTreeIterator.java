package family_tree;
import java.util.Iterator;
import java.util.List;


@SuppressWarnings("rawtypes")
public class FamilyTreeIterator<T extends TreeNode> implements Iterator<T> {
    private final List<T> list;
    private int index;

    public FamilyTreeIterator(List<T> humans){
        this.list = humans;
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
