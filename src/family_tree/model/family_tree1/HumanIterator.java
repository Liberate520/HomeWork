package family_tree.model.family_tree1;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends ItemFamilyTree> implements Iterator<E> {

    private int currentID;
    private final List<E> humans;

    public HumanIterator(List<E> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > currentID;
    }

    @Override
    public E next() {
        return humans.get(currentID++);
    }
}
