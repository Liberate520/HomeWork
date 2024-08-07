package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByAge сравнивает элементы семейного древа по возрасту.
 *
 * @param <E> тип элемента семейного древа, реализующего интерфейс FamilyTreeElement
 */
public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного древа по их возрасту.
     *
     * @param o1 первый элемент семейного древа
     * @param o2 второй элемент семейного древа
     * @return отрицательное целое число, ноль или положительное целое число, если возраст
     *         первого элемента меньше, равен или больше возраста второго элемента соответственно
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
