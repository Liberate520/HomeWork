package views;

import models.Human;
import models.FamilyTree;

/**
 * Интерфейс View определяет методы для взаимодействия с пользовательским интерфейсом.
 */
public interface View {
    /**
     * Отображает генеалогическое древо.
     *
     * @param familyTree генеалогическое древо для отображения
     */
    void displayFamilyTree(FamilyTree<Human> familyTree);

    /**
     * Отображает генеалогическое древо, отсортированное по имени.
     *
     * @param familyTree генеалогическое древо для отображения
     */
    void displaySortedByName(FamilyTree<Human> familyTree);

    /**
     * Отображает генеалогическое древо, отсортированное по дате рождения.
     *
     * @param familyTree генеалогическое древо для отображения
     */
    void displaySortedByBirthDate(FamilyTree<Human> familyTree);

    /**
     * Отображает загруженное генеалогическое древо.
     *
     * @param familyTree загруженное генеалогическое древо
     */
    void displayLoadedFamilyTree(FamilyTree<Human> familyTree);

    /**
     * Отображает сообщение об ошибке.
     *
     * @param errorMessage сообщение об ошибке
     */
    void displayError(String errorMessage);
}