package ru.gb.family.familyTree;

import ru.gb.family.humans.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curID;
    private List<Human> familyTree;


    @Override

    public boolean hasNext() {
        return familyTree.size()>curID;
    }

    @Override
    public Human next() {
        return familyTree.get(curID++);
    }
}
