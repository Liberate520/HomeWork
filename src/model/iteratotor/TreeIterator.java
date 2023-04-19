package model.iteratotor;
import java.util.Iterator;
import java.util.Map;

import model.person.Person;

public class TreeIterator<E extends Person> implements Iterator<E> {
    private Map<Integer, E> persons_list;
    private Iterator<Integer> iterator;
    private int size;

    public TreeIterator(Map<Integer, E> persons_list) {
        this.persons_list = persons_list;
        this.iterator = persons_list.keySet().iterator();
        this.size = persons_list.size();
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    @Override
    public E next() {
        size--;
        return persons_list.get(iterator.next());
    }

}