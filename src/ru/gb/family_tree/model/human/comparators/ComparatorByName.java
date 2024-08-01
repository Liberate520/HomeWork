package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Компаратор для сравнения элементов семейного древа по имени.
 *
 * @param <E> тип элемента семейного древа, который должен расширять {@link FamilyTreeElement}.
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного древа по их именам.
     *
     * @param o1 первый элемент для сравнения.
     * @param o2 второй элемент для сравнения.
     * @return отрицательное целое число, ноль или положительное целое число, если имя первого элемента
     * меньше, равно или больше имени второго элемента соответственно.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
