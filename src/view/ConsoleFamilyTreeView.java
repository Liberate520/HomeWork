package view;

import model.person.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView<Person> {
    private Scanner scanner;
    private String name;
    private String gender;
    private String birthDate;
    private String deathDate;

    public ConsoleFamilyTreeView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Добавить человека");
        System.out.println("2 - Показать дерево");
        System.out.println("3 - Сортировать по имени");
        System.out.println("4 - Сортировать по дате рождения");
        System.out.println("5 - Сохранить дерево в файл");
        System.out.println("6 - Загрузить дерево из файла");
        System.out.println("0 - Выход");
        System.out.print("Введите команду: ");
    }

    @Override
    public void displayTree(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.getName() + " (" + person.getBirthDate() + ")");
        }
    }

    @Override
    public void promptForPersonDetails() {
        System.out.print("Введите имя: ");
        name = scanner.nextLine().trim();

        System.out.print("Введите пол: ");
        gender = scanner.nextLine().trim();

        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        birthDate = scanner.nextLine().trim();

        System.out.print("Введите дату смерти (гггг-мм-дд) или оставьте пустым: ");
        deathDate = scanner.nextLine().trim();
    }

    @Override
    public void showSaveSuccess(String fileName) {
        System.out.println("Дерево сохранено в " + fileName);
    }

    @Override
    public void showLoadSuccess(String fileName) {
        System.out.println("Дерево загружено из " + fileName);
    }

    @Override
    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }

    @Override
    public String getInput() {
        return scanner.nextLine().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getDeathDate() {
        return deathDate;
    }

    @Override
    public String getFileName() {
        System.out.print("Введите имя файла: ");
        return scanner.nextLine().trim();
    }
}
