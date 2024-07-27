package ru.gb.family_tree.family_tree;

import java.time.LocalDate;
import java.util.Comparator;

public class FamilyTreeComparatorByBirthDate<T extends TreeNode<T>> implements Comparator<T> {

    //    @Override
//    public int compare(T o1, T o2) {
//        return o1.getBirthDate().compareTo(o2.getBirthDate());
//    }
    @Override
    public int compare(T o1, T o2) {
        // Проверка на null для объекта
        if (o1 == null && o2 == null) {
            return 0; // Оба объекта равны
        }
        if (o1 == null) {
            return -1; // o1 меньше, если o2 не null
        }
        if (o2 == null) {
            return 1; // o1 больше, если o2 не null
        }

        // Получение дат рождения
        LocalDate birthDate1 = o1.getBirthDate();
        LocalDate birthDate2 = o2.getBirthDate();

        // Проверка на null для дат рождения
        if (birthDate1 == null && birthDate2 == null) {
            return 0; // Оба года равны
        }
        if (birthDate1 == null) {
            return -1; // null меньше любой даты
        }
        if (birthDate2 == null) {
            return 1; // любая дата больше null
        }

        // Сравнение местожительства
        return birthDate1.compareTo(birthDate2);
    }
}
