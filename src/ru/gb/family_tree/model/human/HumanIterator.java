package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.familly_tree.ItemFamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends ItemFamilyTree> implements Iterator<T> {// описание класса, который требует два метода
    private int currentId;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > currentId;
    }

    @Override
    public T next() {
        return humanList.get(currentId++);
    }


}
