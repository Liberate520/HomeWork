package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

/**
 * Класс ComparatorByAge реализует интерфейс Comparator для сравнения элементов семейного дерева по возрасту.
 *
 * @param <E> Тип элементов семейного дерева, которые должны расширять FamilyTreeElement.
 */
public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два объекта по возрасту.
     *
     * @param o1 Первый объект для сравнения.
     * @param o2 Второй объект для сравнения.
     * @return Отрицательное значение, если возраст первого объекта меньше возраста второго;
     *         ноль, если возраст объектов равен;
     *         положительное значение, если возраст первого объекта больше возраста второго.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
