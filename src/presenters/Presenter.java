package presenters;

import models.Human;
import models.FamilyTree;
import services.FamilyTreeFileHandler;
import views.View;

/**
 * Класс Presenter связывает модель и представление, обрабатывая команды пользователя и обновляя модель данных.
 */
public class Presenter {
    private final View view;
    private final FamilyTree<Human> familyTree;
    private final FamilyTreeFileHandler<Human> fileHandler;

    /**
     * Конструктор класса Presenter.
     *
     * @param view объект представления, реализующий интерфейс View
     */
    public Presenter(View view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FamilyTreeFileHandler<>();
    }

    /**
     * Добавляет человека в генеалогическое древо.
     *
     * @param human человек, который добавляется в древо
     */
    public void addHuman(Human human) {
        familyTree.add(human);
    }

    /**
     * Сортирует генеалогическое древо по имени и отображает результат.
     */
    public void sortByName() {
        familyTree.sortByName();
        view.displaySortedByName(familyTree);
    }

    /**
     * Сортирует генеалогическое древо по дате рождения и отображает результат.
     */
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.displaySortedByBirthDate(familyTree);
    }

    /**
     * Сохраняет генеалогическое древо в файл.
     *
     * @param filename имя файла для сохранения
     */
    public void saveToFile(String filename) {
        try {
            fileHandler.saveFamilyTree(familyTree, filename);
        } catch (Exception e) {
            view.displayError("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    /**
     * Загружает генеалогическое древо из файла.
     *
     * @param filename имя файла для загрузки
     */
    public void loadFromFile(String filename) {
        try {
            FamilyTree<Human> loadedFamilyTree = fileHandler.loadFamilyTree(filename);
            view.displayLoadedFamilyTree(loadedFamilyTree);
        } catch (Exception e) {
            view.displayError("Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    /**
     * Отображает генеалогическое древо.
     */
    public void displayFamilyTree() {
        view.displayFamilyTree(familyTree);
    }
}