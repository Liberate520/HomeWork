package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

/**
 * Класс ComparatorByAge реализует интерфейс Comparator для сравнения объектов Human по возрасту.
 * Используется для сортировки объектов Human по их возрасту в возрастающем порядке.
 */
public class ComparatorByAge implements Comparator<Human> {
    /**
     * Сравнивает два объекта Human по их возрасту.
     *
     * @param o1 первый объект Human для сравнения
     * @param o2 второй объект Human для сравнения
     * @return отрицательное целое число, если возраст первого объекта меньше возраста второго;
     *         ноль, если возрасты равны;
     *         положительное целое число, если возраст первого объекта больше возраста второго.
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}