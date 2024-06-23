package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Класс List обеспечивает работу со списком объектов типа T.
 * Он реализует интерфейс Iterable<T>, что позволяет использовать его в циклах for-each.
 *
 * @param <T> тип объектов, которые будут храниться в списке
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

    /**
     * Возвращает листовой итератор для списка объектов.
     *
     * @return листовой итератор для списка объектов
     */
    public ListIterator<T> listIterator() {
        return list.listIterator();
    }

    /**
     * Возвращает листовой итератор для списка объектов, начиная с указанной позиции.
     *
     * @param index начальная позиция для листового итератора
     * @return листовой итератор для списка объектов
     */
    public ListIterator<T> listIterator(int index) {
        return list.listIterator(index);
    }
}