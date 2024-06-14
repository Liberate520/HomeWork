package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService extends FamilyTree<Node> {
    private final IOOperations<Node> ioOperations;

    public FamilyTreeService() {
        super(); // Вызов конструктора суперкласса FamilyTree<Node>()
        this.ioOperations = new FileIO<>();
    }

    // Метод для добавления узла
    public void addNode(String name, String gender, LocalDate birthDate) {
        Node node = new Node(name, Gender.valueOf(gender), birthDate);
        super.addNode(node); // Использование метода addNode из суперкласса
    }

    // Метод для удаления узла
    public boolean removeNode(String name) {
        return super.removeNode(name); // Использование метода removeNode из суперкласса
    }

    // Метод для сохранения дерева в файл
    public void saveTreeToFile(String filename) {
        try {
            super.saveTreeToFile(filename); // Использование метода saveTreeToFile из суперкласса
        } catch (IOException e) {
            e.printStackTrace();
            // Логгирование ошибки
        }
    }

    // Метод для загрузки дерева из файла
    public void loadTreeFromFile(String filename) {
        try {
            super.loadTreeFromFile(filename); // Использование метода loadTreeFromFile из суперкласса
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Логгирование ошибки
        }
    }

    // Метод для сортировки узлов по имени
    public void sortByName() {
        super.sortByName(); // Использование метода sortByName из суперкласса
    }

    // Метод для сортировки узлов по дате рождения
    public void sortByBirthDate() {
        super.sortByBirthDate(); // Использование метода sortByBirthDate из суперкласса
    }

    // Метод для получения всех узлов
    public List<Node> getAllNodes() {
        return super.getNodes(); // Использование метода getNodes из суперкласса
    }

    // Метод для печати дерева
    public void printTree() {
        super.printTree(); // Использование метода printTree из суперкласса
    }
}