package ru.gb.family_tree.model.human;

import java.io.Serializable;

/**
 * Перечисление Gender представляет пол человека.
 * Это перечисление может быть сериализовано.
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
