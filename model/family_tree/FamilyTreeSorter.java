package model.family_tree;

import java.util.Comparator;
import java.util.List;

// Применяем SRP: Класс FamilyTreeSorter отвечает за сортировку.
// Применяем OCP: Класс FamilyTreeSorter поддерживает различные стратегии сортировки.
public class FamilyTreeSorter<E extends FamilyTreeItem<E>> {
    public void sort(List<E> humanList, Comparator<E> comparator) {
        humanList.sort(comparator);
    }
}
