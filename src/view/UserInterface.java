package view;

import Presenter.FamilyTreePresenter;
import model.FamilyTreeService;
import model.Gender;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface implements IUserInterface {
    private final FamilyTreePresenter presenter;
    private final Scanner scanner;

    public UserInterface(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        // Метод пока не используется, можно реализовать при необходимости
    }

    @Override
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("Введите команду (add, remove, save, load, sortByName, sortByBirthDate, print, exit):");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add" -> addNode();
                case "remove" -> removeNode();
                case "save" -> saveTree();
                case "load" -> loadTree();
                case "sortbyname" -> presenter.sortByName();
                case "sortbybirthdate" -> presenter.sortByBirthDate();
                case "print" -> presenter.printTree();
                case "exit" -> running = false;
                default -> System.out.println("Неверная команда. Попробуйте еще раз.");
            }
        }
    }

    private void addNode() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine().trim();

        System.out.println("Введите пол (Male/Female):");
        String genderInput = scanner.nextLine().trim().toUpperCase();
        Gender gender = parseGender(genderInput);

        if (gender == null) {
            System.out.println("Неверный ввод пола. Пожалуйста, введите 'Male' или 'Female'.");
            return;
        }

        System.out.println("Введите дату рождения (гггг-мм-дд):");
        String birthDateInput = scanner.nextLine().trim();
        LocalDate birthDate = parseDate(birthDateInput);

        if (birthDate == null) {
            System.out.println("Неверный формат даты. Пожалуйста, используйте формат 'гггг-мм-дд'.");
            return;
        }

        presenter.addNode(name, String.valueOf(gender), birthDate);
    }

    private void removeNode() {
        System.out.println("Введите имя узла для удаления:");
        String name = scanner.nextLine().trim();
        presenter.removeNode(name);
    }

    private void saveTree() {
        System.out.println("Введите имя файла для сохранения:");
        String filename = scanner.nextLine().trim();
        presenter.saveTree(filename);
    }

    private void loadTree() {
        System.out.println("Введите имя файла для загрузки:");
        String filename = scanner.nextLine().trim();
        presenter.loadTree(filename);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

    private Gender parseGender(String genderInput) {
        try {
            return Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput);
        } catch (DateTimeException e) {
            return null;
        }
    }
}