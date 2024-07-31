package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

/**
 * Класс ComparatorByName реализует интерфейс Comparator для сравнения объектов,
 * которые являются элементами семейного древа, по их именам.
 *
 * @param <E> тип элементов, которые являются наследниками FamilyTreeElement
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два объекта типа E по их именам.
     *
     * @param o1 первый объект для сравнения
     * @param o2 второй объект для сравнения
     * @return отрицательное целое число, если имя первого объекта меньше имени второго объекта;
     *         ноль, если имена равны;
     *         положительное целое число, если имя первого объекта больше имени второго объекта
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
