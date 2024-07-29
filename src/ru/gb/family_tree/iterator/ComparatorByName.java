package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

/**
 * Класс ComparatorByName реализует интерфейс Comparator для сравнения объектов Human по имени.
 * Используется для сортировки объектов Human по их имени в алфавитном порядке.
 */
public class ComparatorByName implements Comparator<Human> {
    /**
     * Сравнивает два объекта Human по их имени.
     *
     * @param o1 первый объект Human для сравнения
     * @param o2 второй объект Human для сравнения
     * @return отрицательное целое число, если имя первого объекта предшествует имени второго по алфавиту;
     *         ноль, если имена равны;
     *         положительное целое число, если имя первого объекта следует за именем второго по алфавиту.
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}