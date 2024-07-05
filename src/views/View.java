package views;

import models.Human;
import models.FamilyTree;
import presenters.Presenter;

/**
 * Интерфейс View определяет методы для взаимодействия с пользовательским интерфейсом.
 * Он обеспечивает абстракцию для отображения информации и получения команд от пользователя.
 */
public interface View {
    /**
     * Запускает приложение и начинает взаимодействие с пользователем.
     *
     * @param presenter объект презентера для обработки команд пользователя
     */
    void start(Presenter presenter);

    /**
     * Отображает генеалогическое древо в консоли в указанном порядке сортировки.
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