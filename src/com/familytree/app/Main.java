package com.familytree.app;

import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.view.FamilyTreeView;
import com.familytree.view.FamilyTreeViewImpl;
import com.familytree.model.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new FamilyTreeViewImpl();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);
        Scanner scanner = new Scanner(System.in);


        presenter.addPerson("Николай", LocalDate.of(1970, 4, 19), Gender.Male);
        presenter.addPerson("Ольга", LocalDate.of(1969, 1, 11), Gender.Female);
        presenter.addPerson("Анна", LocalDate.of(2000, 3, 3), Gender.Female);
        presenter.addPerson("Алексей", LocalDate.of(1999, 3, 6), Gender.Male);

        // Установка родителей
        presenter.setParents("Анна", "Ольга", "Николай");
        presenter.setParents("Алексей", "Ольга", "Николай");

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Установить родителей");
            System.out.println("3. Показать детей человека");
            System.out.println("4. Показать людей, отсортированных по имени");
            System.out.println("5. Показать людей, отсортированных по дате рождения");
            System.out.println("6. Сохранить семейное дерево в файл");
            System.out.println("7. Загрузить семейное дерево из файла");
            System.out.println("8. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Поглощаем символ новой строки

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
                    String dobInput = scanner.nextLine();
                    LocalDate dob = LocalDate.parse(dobInput);
                    System.out.print("Введите пол (Male/Female): ");
                    String genderInput = scanner.nextLine();
                    Gender gender = Gender.valueOf(genderInput);
                    presenter.addPerson(name, dob, gender);
                    break;
                case 2:
                    System.out.print("Введите имя ребенка: ");
                    String childName = scanner.nextLine();
                    System.out.print("Введите имя матери: ");
                    String motherName = scanner.nextLine();
                    System.out.print("Введите имя отца: ");
                    String fatherName = scanner.nextLine();
                    presenter.setParents(childName, motherName, fatherName);
                    break;
                case 3:
                    System.out.print("Введите имя человека для показа его детей: ");
                    String personName = scanner.nextLine();
                    presenter.showChildren(personName);
                    break;
                case 4:
                    presenter.showPeopleSortedByName();
                    break;
                case 5:
                    presenter.showPeopleSortedByBirthDate();
                    break;
                case 6:
                    System.out.print("Введите имя файла для сохранения: ");
                    String saveFilename = scanner.nextLine();
                    presenter.saveFamilyTree(saveFilename);
                    break;
                case 7:
                    System.out.print("Введите имя файла для загрузки: ");
                    String loadFilename = scanner.nextLine();
                    presenter.loadFamilyTree(loadFilename);
                    break;
                case 8:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}