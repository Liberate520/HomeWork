package family_tree.presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import family_tree.model.FamilyTreeModel;
import family_tree.model.Human;
import family_tree.view.FamilyTreeView;
import family_tree.model.TextTreeReaderWriter;
import java.util.Comparator;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;
    private TextTreeReaderWriter readerWriter;

    public FamilyTreePresenter(FamilyTreeModel model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
        this.readerWriter = new TextTreeReaderWriter();
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
        readerWriter.saveTreeToFile(model, fileName); // Вызов метода сохранения дерева в файл
    }

    public void onLoadTreeFromFile(String fileName) {
        FamilyTreeModel loadedModel = readerWriter.loadTreeFromFile(fileName); // Загрузка дерева из файла
        if (loadedModel != null) {
            model = loadedModel; // Обновление модели загруженными данными
            view.displayMessage("Дерево успешно загружено из файла.");
        } else {
            view.displayErrorMessage("Не удалось загрузить дерево из файла.");
        }
    }
}
