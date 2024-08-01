package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByAge предоставляет возможность сравнивать объекты
 * типа FamilyTreeElement по их возрасту.
 *
 * @param <E> тип элементов семейного дерева, которые будут сравниваться.
 *            Должен наследоваться от FamilyTreeElement.
 */
public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два объекта типа E по их возрасту.
     *
     * @param o1 первый объект для сравнения.
     * @param o2 второй объект для сравнения.
     * @return отрицательное число, если возраст o1 меньше возраста o2;
     *         ноль, если возрасты равны;
     *         положительное число, если возраст o1 больше возраста o2.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
