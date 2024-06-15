package utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс List обеспечивает работу с списком объектов.
 */
public class List<T> implements Iterable<T> {
    private java.util.List<T> list;

    /**
     * Конструктор класса List.
     */
    public List() {
        this.list = new ArrayList<>();
    }

    /**
     * Добавляет объект в список.
     *
     * @param element объект для добавления
     */
    public void add(T element) {
        list.add(element);
    }

    /**
     * Возвращает список объектов.
     *
     * @return список объектов
     */
    public java.util.List<T> getElements() {
        return list;
    }

    /**
     * Возвращает итератор для списка объектов.
     *
     * @return итератор для списка объектов
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
