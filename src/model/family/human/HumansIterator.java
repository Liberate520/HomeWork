package model.family.human;

import model.family.Alivable;

import java.util.Iterator;
import java.util.List;

public class HumansIterator<T extends Alivable<T>> implements Iterator<T> {
    private List<T> list;
    private int index;
    public HumansIterator(List<T> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}