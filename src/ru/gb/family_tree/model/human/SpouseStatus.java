package ru.gb.family_tree.model.human;

/**
 * Перечисление SpouseStatus представляет статус супруга в семейном дереве.
 * Оно может принимать два значения:
 * <ul>
 *     <li>{@link #actual} - текущий супруг</li>
 *     <li>{@link #ex} - бывший супруг</li>
 * </ul>
 */
public enum SpouseStatus {
    /**
     * Текущий супруг.
     */
    actual,

    /**
     * Бывший супруг.
     */
    ex
}
