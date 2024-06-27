package views;

import models.Human;
import models.FamilyTree;

/**
 * Интерфейс View определяет методы для взаимодействия с пользовательским интерфейсом.
 */
public interface View {
    /**
     * Отображает генеалогическое древо в указанном порядке сортировки.
     *
     * @param familyTree генеалогическое древо для отображения
     * @param sortOrder  порядок сортировки для отображения
     */
    void displayFamilyTree(FamilyTree<Human> familyTree, SortOrder sortOrder);

    /**
     * Отображает сообщение об ошибке.
     *
     * @param errorMessage сообщение об ошибке
     */
    void displayError(String errorMessage);

    /**
     * Запрашивает у пользователя информацию о новом человеке и возвращает его.
     *
     * @return новый человек
     */
    Human addHuman();
}
