package view;
import Presenter.FamilyTreePresenter;
import model.FamilyTree;
import model.Node;
import model.Gender;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {

    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
        // Этот метод пока не реализован, но необходим для совместимости с интерфейсом.
    }

    public void start() {
        if (presenter == null) {
            System.out.println("Ошибка: Презентер не установлен. Используйте метод setPresenter.");
            return;
        }

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
                    presenter.sortByName();
                    break;
                case "sortByBirthDate":
                    presenter.sortByBirthDate();
                    break;
                case "print":
                    presenter.printTree();
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

        presenter.addNode(name, genderInput, birthDate);
    }

    private void removeNode() {
        System.out.println("Введите имя узла для удаления:");
        String name = scanner.nextLine();
        presenter.removeNode(name);
    }

    private void saveTree() {
        System.out.println("Введите имя файла для сохранения:");
        String filename = scanner.nextLine();
        presenter.saveTree(filename);
    }

    private void loadTree() {
        System.out.println("Введите имя файла для загрузки:");
        String filename = scanner.nextLine();
        presenter.loadTree(filename);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }
}