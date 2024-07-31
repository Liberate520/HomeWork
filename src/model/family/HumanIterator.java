package model.family;

import model.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> people;

    public HumanIterator(List<Human> people){
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return index < people.size();
    }

    @Override
    public Human next() {
        return people.get(index++);
    }
}
