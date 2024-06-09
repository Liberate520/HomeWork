package Presenter;
import Presenter.*;
import model.FamilyTree;
import model.Node;
import view.UserInterface;

import java.io.IOException;

public class FamilyTreePresenter {
    private final FamilyTree<Node> familyTree;
    private final UserInterface userInterface;

    public FamilyTreePresenter(FamilyTree<Node> familyTree, UserInterface userInterface) {
        this.familyTree = familyTree;
        this.userInterface = userInterface;
    }

    public void start() {
        userInterface.setPresenter(this);
        userInterface.start();
    }

    public void addNode(Node node) {
        familyTree.addNode(node);
    }

    public boolean removeNode(String name) {
        return familyTree.removeNode(name);
    }

    public void saveTree(String filename) {
        try {
            familyTree.saveTreeToFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
            userInterface.displayErrorMessage("Ошибка при сохранении дерева в файл " + filename);
        }
    }

    public void loadTree(String filename) {
        try {
            familyTree.loadTreeFromFile(filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            userInterface.displayErrorMessage("Ошибка при загрузке дерева из файла " + filename);
        }
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void printTree() {
        familyTree.printTree();
    }
}