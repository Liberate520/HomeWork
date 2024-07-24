package familyTree;

import java.util.Iterator;
import java.util.List;

public class IteratorFT implements Iterator <Human> {
      
    private int index;
    public List <Human> family;

    public IteratorFT(List <Human> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public Human next() {
        return family.get(index++);
    }
}