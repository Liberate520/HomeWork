package family_tree.FamilyTree;

import family_tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends FamilyTreeElements<E>> implements Iterator<E> {
    private int index;
    private List<E> list;

    public HumanIterator(List<E> list){
        this.list = list;

    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
