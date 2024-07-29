package familytree.family_tree;

import java.util.Iterator;
import java.util.List;
import familytree.human.Human;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> humans;
    private int index;

    public FamilyTreeIterator (List<Human> humans){
        this.humans = humans;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(index++);
    }
}
