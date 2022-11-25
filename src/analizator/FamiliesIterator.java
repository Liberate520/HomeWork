package analizator;

import java.util.ArrayList;
import java.util.Iterator;

public class FamiliesIterator implements Iterator<Pair> {
    private int index;
    private final ArrayList<Pair> db;

    public FamiliesIterator(ArrayList<Pair> familiesList) {
        this.index = 0;
        this.db = familiesList;
    }

    @Override
    public boolean hasNext() {
        return index < this.db.size();
    }

    @Override
    public Pair next() {
        return this.db.get(index++);
    }
}
