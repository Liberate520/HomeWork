package Presenter;
import Presenter.*;
import model.FamilyTree;
import model.Node;
import view.UserInterface;
import model.Gender;
import java.io.IOException;
import java.time.LocalDate;
public class FamilyTreePresenter {
    private final FamilyTree<Node> familyTree;

    private final UserInterface userInterface;

    public FamilyTreePresenter(FamilyTree<Node> familyTree, UserInterface userInterface) {
        this.familyTree = familyTree;
        this.userInterface = userInterface;
    }

    public void addNode(String name, String gender, LocalDate birthDate) {
        Gender nodeGender = Gender.valueOf(gender);
        Node node = new Node(name, nodeGender, birthDate);
        familyTree.addNode(node);
        userInterface.displayMessage("Узел успешно добавлен.");
    }

    public boolean removeNode(String name) {
        boolean removed = familyTree.removeNode(name);
        if (removed) {
            userInterface.displayMessage("Узел успешно удален.");
        } else {
            userInterface.displayMessage("Узел с таким именем не найден.");
        }
        return removed;
    }

    public void saveTree(String filename) {
        try {
            familyTree.saveTreeToFile(filename);
            userInterface.displayMessage("Дерево успешно сохранено в файл " + filename);
        } catch (Exception e) {
            userInterface.displayErrorMessage("Ошибка при сохранении дерева: " + e.getMessage());
        }
    }

    public void loadTree(String filename) {
        try {
            familyTree.loadTreeFromFile(filename);
            userInterface.displayMessage("Дерево успешно загружено из файла " + filename);
        } catch (Exception e) {
            userInterface.displayErrorMessage("Ошибка при загрузке дерева: " + e.getMessage());
        }
    }

    public void sortByName() {
        familyTree.sortByName();
        userInterface.displayMessage("Дерево отсортировано по имени.");
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        userInterface.displayMessage("Дерево отсортировано по дате рождения.");
    }

    public void printTree() {
        familyTree.printTree();
    }
}