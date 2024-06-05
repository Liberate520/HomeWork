package Model.TypeOfRelationship;
import java.util.Iterator;
import java.util.List;

public class РersonIterator<E> implements Iterator<E> {
    private int index;
    private List<E> tree;
    public РersonIterator(List<E> tree) {
        this.tree = tree;
    }
    @Override
    public boolean hasNext() {
        return index < tree.size();
    }
    @Override
    public E next() {
        return tree.get(index++);
    }
}