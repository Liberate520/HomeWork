package ru.gb2.family_tree7.model.human.comparators;

import ru.gb2.family_tree7.model.group.GroupItem;
import ru.gb2.family_tree7.model.human.Human;

import java.util.Comparator;

public class HumanComparatorByDeathDate<T extends GroupItem> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0; // Оба равны
        }
        if (o1 == null) {
            return 1; // Считаем, что o1 "больше", то есть живой человек идет после умершего
        }
        if (o2 == null) {
            return -1; // o1 не null, значит он "меньше"
        }

        // Сравниваем по дате смерти
        if (o1.getDeathDate() == null && o2.getDeathDate() == null) {
            return 0; // Оба живы, считаем равными
        }
        if (o1.getDeathDate() == null) {
            return 1; // Живой человек идет после умершего
        }
        if (o2.getDeathDate() == null) {
            return -1; // Умерший идет перед живым
        }

        return o1.getDeathDate().compareTo(o2.getDeathDate());
    }
}