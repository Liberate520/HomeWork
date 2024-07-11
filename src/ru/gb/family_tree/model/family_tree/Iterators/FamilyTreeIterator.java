package ru.gb.family_tree.model.family_tree.Iterators;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E> implements Iterator<E> {
    private final List<E> list;
    private int index;

    public FamilyTreeIterator(List<E> list) {
        this.list = list != null ? list : List.of(); // Инициализация пустым списком, если list равен null
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
