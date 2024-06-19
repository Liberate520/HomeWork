package model.human;


import model.tree.TreeItem;

import java.util.*;

public class HumanIterator<T extends TreeItem> implements Iterator<T>{
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