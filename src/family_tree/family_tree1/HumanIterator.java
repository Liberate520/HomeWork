package family_tree.family_tree1;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int currentID;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > currentID;
    }

    @Override
    public Human next() {
        return humans.get(currentID++);
    }
}
