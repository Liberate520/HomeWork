package utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс ArrayList реализует интерфейс List и представляет динамический массив объектов.
 * Он обеспечивает базовые операции для работы со списком, такие как добавление, удаление, получение и сортировка элементов.
 *
 * @param <T> тип объектов, которые будут храниться в списке
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    /**
     * Конструктор класса ArrayList.
     */
    public ArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Добавляет объект в конец списка.
     *
     * @param element объект, который добавляется в список
     */
    @Override
    public void add(T element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    /**
     * Увеличивает емкость массива, если он заполнен.
     */
    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * Добавляет все объекты из другого списка в конец текущего списка.
     *
     * @param list список объектов для добавления
     */
    @Override
    public void addAll(List<T> list) {
        for (T element : list) {
            add(element);
        }
    }

    /**
     * Удаляет все элементы из списка.
     */
    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    /**
     * Возвращает объект по указанному индексу.
     *
     * @param index индекс объекта для получения
     * @return объект по указанному индексу
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ списка: " + index);
        }
        return array[index];
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Сортирует элементы списка в соответствии с указанным компаратором.
     *
     * @param comparator компаратор для сортировки элементов
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort(array, 0, size, comparator);
    }

    /**
     * Возвращает строковое представление списка.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}