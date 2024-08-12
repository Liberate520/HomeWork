package model.familiTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {


    private List<T> list;
    private int currentId;

    public FamilyTreeIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() { // метод hasNext() проверяет есть ли следующий объект
        return list.size() > currentId;
    }

    @Override
    public T next() { // метод next() возвращает следующий объект
        return list.get(currentId++);
    }
}
