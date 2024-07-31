package ru.gb.family_tree.human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {// описание класса, который требует два метода
    private int currentId;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > currentId;
    }

    @Override
    public Human next() {
        return humanList.get(currentId++);
    }


}
