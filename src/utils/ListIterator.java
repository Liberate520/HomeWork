package utils;

import java.util.NoSuchElementException;

/**
 * Класс ListIterator реализует итератор для перебора элементов списка.
 * Он предоставляет методы для проверки наличия следующего элемента и получения следующего элемента.
 *
 * @param <T> тип элементов списка
 */
public class ListIterator<T> {
    private final T[] array;
    private int index;

    /**
     * Конструктор класса ListIterator.
     *
     * @param list список, для которого создается итератор
     */
    public ListIterator(List<T> list) {
        this.array = (T[]) list.toArray();
        this.index = 0;
    }

    /**
     * Проверяет наличие следующего элемента в итераторе.
     *
     * @return true, если есть следующий элемент, false в противном случае
     */
    public boolean hasNext() {
        return index < array.length;
    }

    /**
     * Возвращает следующий элемент в итераторе.
     *
     * @return следующий элемент
     * @throws NoSuchElementException если нет следующего элемента
     */
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}