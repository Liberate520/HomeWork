package Presenter;

import model.FamilyTreeService;
import model.Node;
import view.UserInterface;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private final FamilyTreeService familyTreeService;
    private UserInterface userInterface = null;

    public FamilyTreePresenter(FamilyTreeService familyTreeService) {
        this.familyTreeService = familyTreeService;
        this.userInterface = userInterface;
    }

    public void addNode(String name, String gender, LocalDate birthDate) {
        // Предполагается, что gender передается как строка "Male" или "Female"
        familyTreeService.addNode(name, gender, birthDate);
        userInterface.displayMessage("Узел успешно добавлен.");
    }

    public boolean removeNode(String name) {
        boolean removed = familyTreeService.removeNode(name);
        if (removed) {
            userInterface.displayMessage("Узел успешно удален.");
        } else {
            userInterface.displayMessage("Узел с таким именем не найден.");
        }
        return removed;
    }

    public void saveTree(String filename) {
        try {
            familyTreeService.saveTreeToFile(filename);
            userInterface.displayMessage("Дерево успешно сохранено в файл " + filename);
        } catch (Exception e) {
            userInterface.displayErrorMessage("Ошибка при сохранении дерева в файл " + filename + ": " + e.getMessage());
        }
    }

    public List<Node> loadTree(String filename) {
        try {
            List<Node> loadedNodes = familyTreeService.loadTreeFromFile(filename);
            userInterface.displayMessage("Дерево успешно загружено из файла " + filename);
            return loadedNodes;
        } catch (Exception e) {
            userInterface.displayErrorMessage("Ошибка при загрузке дерева из файла " + filename + ": " + e.getMessage());
            return null;
        }
    }

    public void sortByName() {
        familyTreeService.sortByName();
        userInterface.displayMessage("Дерево отсортировано по имени.");
    }

    public void sortByBirthDate() {
        familyTreeService.sortByBirthDate();
        userInterface.displayMessage("Дерево отсортировано по дате рождения.");
    }

    public void printTree() {
        familyTreeService.printTree();
    }
}