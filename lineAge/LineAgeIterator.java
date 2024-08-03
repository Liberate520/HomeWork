package com.oop.homeWorkOOP.lineAge;

import java.util.Iterator;
import java.util.List;

import com.oop.homeWorkOOP.human.Human;

public class LineAgeIterator implements Iterator<Human> {

    private List<Human> tree;
    private int ind;

    public LineAgeIterator(List<Human> tree) {
        this.tree = tree;
        ind = 0;
    }

    @Override
    public boolean hasNext() {
        return tree.size() > ind;
    }

    @Override
    public Human next() {
        return tree.get(ind++);
    }

}
