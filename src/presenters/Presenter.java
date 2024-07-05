package presenters;

import models.Human;
import models.FamilyTree;
import services.FamilyTreeService;
import views.SortOrder;
import views.View;
import java.io.IOException;

/**
 * Класс Presenter отвечает за связь между представлением (View) и сервисом (FamilyTreeService).
 * Он обрабатывает команды пользователя, полученные от View, и передает их в FamilyTreeService.
 * Также Presenter вызывает соответствующие методы View для отображения информации.
 */
public class Presenter {
    private final View view;
    private final FamilyTreeService familyTreeService;

    /**
     * Конструктор класса Presenter.
     *
     * @param view                представление для взаимодействия с пользователем
     * @param familyTreeService   сервис для управления генеалогическим древом
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
     * Сортирует генеалогическое древо по имени и отображает его в представлении.
     */
    public void sortByName() {
        familyTreeService.sortByName();
        view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.NAME);
    }

    /**
     * Сортирует генеалогическое древо по дате рождения и отображает его в представлении.
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
        try {
            familyTreeService.saveToFile(filename);
        } catch (IOException e) {
            view.displayError("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    /**
     * Загружает генеалогическое древо из файла и отображает его в представлении.
     *
     * @param filename имя файла для загрузки
     */
    public void loadFromFile(String filename) {
        try {
            familyTreeService.loadFromFile(filename);
            view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.LOADED);
        } catch (IOException | ClassNotFoundException e) {
            view.displayError("Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    /**
     * Отображает генеалогическое древо в представлении без сортировки.
     */
    public void displayFamilyTree() {
        view.displayFamilyTree(familyTreeService.getFamilyTree(), SortOrder.UNSORTED);
    }
}