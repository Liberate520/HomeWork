package view;
import Presenter.FamilyTreePresenter;
import model.Gender;
import model.FamilyTree;
import model.Node;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {

    public void setPresenter(FamilyTreePresenter presenter) {
    }

    // Другие методы и функциональности класса UserInterface...


    private FamilyTree<Node> familyTree;
    private Scanner scanner;

    public UserInterface() {
        this.familyTree = new FamilyTree<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Введите команду (add, remove, save, load, sortByName, sortByBirthDate, print, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addNode();
                    break;
                case "remove":
                    removeNode();
                    break;
                case "save":
                    saveTree();
                    break;
                case "load":
                    loadTree();
                    break;
                case "sortByName":
                    familyTree.sortByName();
                    break;
                case "sortByBirthDate":
                    familyTree.sortByBirthDate();
                    break;
                case "print":
                    familyTree.printTree();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда. Попробуйте еще раз.");
            }
        }
    }

    private void addNode() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите пол (Male/Female):");
        String genderInput = scanner.nextLine();
        Gender gender = Gender.valueOf(genderInput);

        System.out.println("Введите дату рождения (гггг-мм-дд):");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateInput);

        Node node = new Node(name, gender, birthDate);
        familyTree.addNode(node);
    }

    private void removeNode() {
        System.out.println("Введите имя узла для удаления:");
        String name = scanner.nextLine();
        boolean removed = familyTree.removeNode(name);
        if (removed) {
            System.out.println("Узел успешно удален.");
        } else {
            System.out.println("Узел с таким именем не найден.");
        }
    }

    private void saveTree() {
        System.out.println("Введите имя файла для сохранения:");
        String filename = scanner.nextLine();
        try {
            familyTree.saveTreeToFile(filename);
            System.out.println("Дерево успешно сохранено в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при сохранении дерева в файл " + filename);
        }
    }

    private void loadTree() {
        System.out.println("Введите имя файла для загрузки:");
        String filename = scanner.nextLine();
        try {
            familyTree.loadTreeFromFile(filename);
            System.out.println("Дерево успешно загружено из файла " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка при загрузке дерева из файла " + filename);
        }
    }

    public void displayErrorMessage(String s) {
    }
}