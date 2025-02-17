package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private final FamilyTree<Node> familyTree;
    private final TreeIO<Node> ioOperations; // Используем интерфейс TreeIO

    public FamilyTreeService(TreeIO<Node> ioOperations) {
        this.familyTree = new FamilyTree<>();
        this.ioOperations = ioOperations; // Инициализируем через переданный интерфейс
    }

    // Метод для добавления узла
    public void addNode(String name, String gender, LocalDate birthDate) {
        Node node = new Node(name, Gender.valueOf(gender), birthDate);
        familyTree.addNode(node);
    }

    // Метод для удаления узла
    public boolean removeNode(String name) {
        return familyTree.removeNode(name);
    }

    // Метод для сохранения дерева в файл
    public void saveTreeToFile(String filename) {
        try {
            ioOperations.saveTree(familyTree.getNodes(), filename); // Используем ioOperations для сохранения
        } catch (IOException e) {
            e.printStackTrace();
            // Логгирование ошибки
        }
    }

    // Метод для загрузки дерева из файла
    public List<Node> loadTreeFromFile(String filename) {
        try {
            List<Node> nodes = ioOperations.loadTree(filename); // Используем ioOperations для загрузки
            for (Node node : nodes) {
                familyTree.addNode(node);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Логгирование ошибки
        }
        return null;
    }

    // Метод для сортировки узлов по имени
    public void sortByName() {
        familyTree.sortByName();
    }

    // Метод для сортировки узлов по дате рождения
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    // Метод для получения всех узлов
    public List<Node> getAllNodes() {
        return familyTree.getNodes();
    }

    // Метод для печати дерева
    public void printTree() {
        familyTree.printTree();
    }
}