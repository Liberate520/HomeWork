package family_tree.presenter;

import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import family_tree.model.FamilyTreeModel;
import family_tree.model.Human;
import family_tree.view.FamilyTreeView;
import java.util.Comparator;
import java.util.List;
import family_tree.model.TreePersistenceService;



public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;
    private TreePersistenceService persistenceService;
    private Scanner scanner;

    public FamilyTreePresenter(FamilyTreeModel model, FamilyTreeView view, TreePersistenceService persistenceService) {
        this.model = model;
        this.view = view;
        this.persistenceService = persistenceService;
        this.scanner = new Scanner(System.in);
    }


    public void onSortByName() {
        List<Human> sortedTree = model.getSortedTree();
        view.displaySortedTree(sortedTree);
    }

    public void onSortByBirthDate() {
        List<Human> sortedTree = model.getSortedTree();
        sortedTree.sort(Comparator.comparing(h -> LocalDate.parse(h.getBirthDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        view.displaySortedTree(sortedTree);
    }

    public void onDisplayUnsortedTree() {
        List<Human> unsortedTree = model.getUnsortedTree();
        view.displayUnsortedTree(unsortedTree);
    }

    public void onSearch(String name) {
        Human foundBeing = model.findBeing(name);
        if (foundBeing != null) {
            view.displayHumanDetails(foundBeing);
        } else {
            view.displayErrorMessage("Человек с именем " + name + " не найден!");
        }
    }

    public void onSaveTreeToFile(String fileName) {
        persistenceService.saveTreeToFile(model, fileName); // Вызов метода сохранения дерева в файл
    }

    public void onLoadTreeFromFile(String fileName) {
        FamilyTreeModel loadedModel = persistenceService.loadTreeFromFile(fileName); // Загрузка дерева из файла
        if (loadedModel != null) {
            model = loadedModel; // Обновление модели загруженными данными
            view.displayMessage("Дерево успешно загружено из файла.");
        } else {
            view.displayErrorMessage("Не удалось загрузить дерево из файла.");
        }
    }

    public void addNewPerson() {
        view.displayMessage("Введите имя нового человека:");
        String newName = scanner.nextLine();
        view.displayMessage("Введите пол нового человека:");
        String newGender = scanner.nextLine();
        view.displayMessage("Введите дату рождения нового человека в формате день-месяц-год:");
        String newBirthDate = scanner.nextLine();
        view.displayMessage("Введите дату смерти нового человека в формате день-месяц-год (оставьте пустым если нет информации):");
        String newDeathDate = scanner.nextLine();
        Human newPerson = new Human(newName, newGender, newBirthDate, newDeathDate);

        view.displayMessage("Введите имена родителей через запятую (если есть):");
        String parentsInput = scanner.nextLine();
        if (!parentsInput.isEmpty()) {
            Arrays.stream(parentsInput.split(",")).forEach(parentName -> {
                Human parent = model.findBeing(parentName.trim());
                if (parent != null) {
                    parent.addChild(newPerson);
                    newPerson.addParent(parent);
                } else {
                    view.displayErrorMessage("Человек с именем " + parentName + " не найден.");
                }
            });
        }

        view.displayMessage("Введите имена детей через запятую (если есть):");
        String childrenInput = scanner.nextLine();
        if (!childrenInput.isEmpty()) {
            Arrays.stream(childrenInput.split(",")).forEach(childName -> {
                Human child = model.findBeing(childName.trim());
                if (child != null) {
                    newPerson.addChild(child);
                    child.addParent(newPerson);
                } else {
                    view.displayErrorMessage("Человек с именем " + childName + " не найден.");
                }
            });
        }

        model.addBeing(newPerson);
        view.displayMessage("Новый человек успешно добавлен в семейное дерево.");
    }

}