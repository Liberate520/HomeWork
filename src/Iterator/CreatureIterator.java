package Iterator;

import Creature.Creature;

import java.util.ArrayList;
import java.util.Iterator;

public class CreatureIterator<T extends Creature<T>> implements Iterator<T> {
    private int currentID = 0;
    private final ArrayList<T> creatures;

    public CreatureIterator(ArrayList<T> creatures){
        this.creatures = creatures;
    }

    @Override
    public boolean hasNext() {
        return creatures.size() < currentID;
    }

    @Override
    public T next() {
        return this.creatures.get(this.currentID++);
    }
}
