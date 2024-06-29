package presenters;

import models.Human;
import models.FamilyTree;
import services.FamilyTreeService;
import views.View;
import views.SortOrder;

/**
 * Класс Presenter связывает представление и сервис, обрабатывая команды пользователя.
 */
public class Presenter {
    private final View view;
    private final FamilyTreeService familyTreeService;

    /**
     * Конструктор класса Presenter.
     *
     * @param view              объект представления, реализующий интерфейс View
     * @param familyTreeService объект сервиса для работы с генеалогическим древом
     */
    public Presenter(View view, FamilyTreeService familyTreeService) {
        this.view = view;
        this.familyTreeService = familyTreeService;
    }

    /**
     * Добавляет человека в генеалогическое древо.
     *
     * @param human человек, который добавляется в древо
     */
    public void addHuman(Human human) {
        familyTreeService.addHuman(human);
    }

    /**
     * Сортирует генеалогическое древо по имени и отображает результат.
     */
    public void sortByName() {
        familyTreeService.sortByName();
        view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.NAME);
    }

    /**
     * Сортирует генеалогическое древо по дате рождения и отображает результат.
     */
    public void sortByBirthDate() {
        familyTreeService.sortByBirthDate();
        view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.BIRTH_DATE);
    }

    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param filename имя файла для сохранения
     */
    public void saveToFile(String filename) {
        familyTreeService.saveToFile(filename);
    }

    /**
     * Загружает генеалогическое древо из файла и отображает результат.
     *
     * @param filename имя файла для загрузки
     */
    public void loadFromFile(String filename) {
        familyTreeService.loadFromFile(filename);
        view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.LOADED);
    }

    /**
     * Отображает генеалогическое древо.
     */
    public void displayFamilyTree() {
        view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.UNSORTED);
    }
}
