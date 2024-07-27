package familyTree;

import java.util.Iterator;
import java.util.List;

public class IteratorFT<E> implements Iterator <E> {
      
    private int index;
    public List <E> family;

    public IteratorFT(List <E> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public E next() {
        return family.get(index++);
    }
}