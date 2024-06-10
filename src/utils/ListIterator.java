package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс ListIterator реализует итератор для списка объектов.
 */
public class ListIterator<T> implements Iterator<T> {
    private ArrayList<T> list;
    private int currentIndex;

    /**
     * Конструктор класса ListIterator.
     *
     * @param list список объектов, для которого создается итератор
     */
    public ListIterator(ArrayList<T> list) {
        this.list = list;
        this.currentIndex = 0;
    }

    /**
     * Проверяет, есть ли следующий элемент в списке.
     *
     * @return true, если есть следующий элемент, иначе false
     */
    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    /**
     * Возвращает следующий элемент в списке.
     *
     * @return следующий элемент в списке
     * @throws NoSuchElementException если больше нет элементов в списке
     */
    @Override
    public T next() {
        if (hasNext()) {
            return list.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}