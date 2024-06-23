package utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс ListIterator обеспечивает итерацию по списку объектов типа T.
 * Он реализует интерфейс Iterator<T>, что позволяет использовать его в циклах for-each.
 *
 * @param <T> тип объектов, по которым выполняется итерация
 */
public class ListIterator<T> implements Iterator<T> {
    private java.util.ListIterator<T> listIterator;

    /**
     * Конструктор класса ListIterator.
     *
     * @param listIterator листовой итератор для списка объектов
     */
    public ListIterator(java.util.ListIterator<T> listIterator) {
        this.listIterator = listIterator;
    }

    /**
     * Возвращает true, если итератор содержит следующий элемент.
     *
     * @return true, если итератор содержит следующий элемент, false в противном случае
     */
    @Override
    public boolean hasNext() {
        return listIterator.hasNext();
    }

    /**
     * Возвращает следующий элемент в итерации.
     *
     * @return следующий элемент в итерации
     * @throws NoSuchElementException если нет следующего элемента
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Нет следующего элемента");
        }
        return listIterator.next();
    }

    /**
     * Удаляет последний элемент, возвращенный методом next().
     *
     * @throws IllegalStateException если метод next() еще не был вызван или элемент уже был удален
     */
    @Override
    public void remove() {
        listIterator.remove();
    }

    /**
     * Возвращает true, если итератор содержит предыдущий элемент.
     *
     * @return true, если итератор содержит предыдущий элемент, false в противном случае
     */
    public boolean hasPrevious() {
        return listIterator.hasPrevious();
    }

    /**
     * Возвращает предыдущий элемент в итерации.
     *
     * @return предыдущий элемент в итерации
     * @throws NoSuchElementException если нет предыдущего элемента
     */
    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("Нет предыдущего элемента");
        }
        return listIterator.previous();
    }

    /**
     * Заменяет элемент, на который указывает итератор, на указанный элемент.
     *
     * @param element новый элемент
     * @throws IllegalStateException если метод next() или previous() еще не был вызван или элемент уже был удален
     */
    public void set(T element) {
        listIterator.set(element);
    }

    /**
     * Добавляет элемент в список на текущую позицию итератора.
     *
     * @param element элемент, который нужно добавить
     */
    public void add(T element) {
        listIterator.add(element);
    }
}