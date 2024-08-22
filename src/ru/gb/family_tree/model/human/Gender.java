package ru.gb.family_tree.model.human;

import java.io.Serializable;

/**
 * Перечисление Gender представляет пол человека.
 * Используется для обозначения пола члена семейного дерева.
 */
public enum Gender implements Serializable {
    /**
     * Мужской пол.
     */
    male,

    /**
     * Женский пол.
     */
    female
}
