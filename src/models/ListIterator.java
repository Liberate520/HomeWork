package models;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
    private List<T>.Node current;

    public ListIterator(List<T> list) {
        current = list.getHead();
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        T data = current.getData();
        current = current.next;
        return data;
    }
}
