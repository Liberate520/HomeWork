package Human.Iterator;

import Human.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human> {
    private int currentID = 0;
    private final ArrayList<Human> humans;

    public HumanIterator(ArrayList<Human> humans){
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() < currentID;
    }

    @Override
    public Human next() {
        return this.humans.get(this.currentID++);
    }
}
