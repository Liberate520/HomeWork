package com.example.familytree.main;

import com.example.familytree.mvp.FamilyTreePresenterImpl;
import com.example.familytree.mvp.FamilyTreeView;
import com.example.familytree.operations.FileFamilyTreeOperations;
import com.example.familytree.operations.FileOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new FamilyTreeView();
        FileOperations fileOps = new FileFamilyTreeOperations();
        FamilyTreePresenterImpl presenter = new FamilyTreePresenterImpl(view, fileOps);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nВыберите команду:");
            System.out.println("1. Добавление человека");
            System.out.println("2. Сортировка по имени");
            System.out.println("3. Сортировка по дате рождения");
            System.out.println("4. Демонстрация фамильного дерева");
            System.out.println("5. Сохранение фамильного дерева в файл");
            System.out.println("6. Загрузка фамильного дерева из файла");
            System.out.println("7. Удаление человека по ID");
            System.out.println("8. Изменение ID человека");
            System.out.println("9. Установить связь родитель-ребенок");
            System.out.println("10. Выход из программы");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        int id = view.getPersonIdInput();
                        String name = view.getPersonNameInput();
                        String birthDate = view.getPersonBirthDateInput();
                        String gender = view.getPersonGenderInput();
                        presenter.addPerson(id, name, birthDate, gender);
                    } catch (NumberFormatException e) {
                        view.displayMessage("Ошибка: ID должен быть числовым значением.");
                    }
                    break;
                case 2:
                    presenter.sortByName();
                    break;
                case 3:
                    presenter.sortByBirthDate();
                    break;
                case 4:
                    presenter.displayTree();
                    break;
                case 5:
                    System.out.print("Введите имя файла: ");
                    String saveFilename = scanner.nextLine();
                    presenter.saveToFile(saveFilename);
                    break;
                case 6:
                    System.out.print("Введите имя файла: ");
                    String loadFilename = scanner.nextLine();
                    presenter.loadFromFile(loadFilename);
                    break;
                case 7:
                    int removeId = view.getPersonIdInput();
                    presenter.removePersonById(removeId);
                    break;
                case 8:
                    System.out.print("Введите старый ID: ");
                    int oldId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Введите новый ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    presenter.changePersonId(oldId, newId);
                    break;
                case 9:
                    int parentId = view.getParentIdInput();
                    int childId = view.getChildIdInput();
                    presenter.setParentChildRelation(parentId, childId);
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте еще раз.");
            }
        }

        scanner.close();
    }
}
