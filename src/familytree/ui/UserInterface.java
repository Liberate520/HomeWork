package familytree.ui;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.io.FamilyTreeFileIO;
import familytree.io.FamilyTreeIO;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private FamilyTree<Person> familyTree;
    private FamilyTreeIO familyTreeIO;
    private Scanner scanner;

    public UserInterface() {
        familyTree = new FamilyTree();
        familyTreeIO = new FamilyTreeFileIO();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    displayTree();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByBirthDate();
                    break;
                case "5":
                    saveTree();
                    break;
                case "6":
                    loadTree();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    private void printMenu() {
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

    private void addPerson() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine().trim();

        System.out.print("Введите пол: ");
        String gender = scanner.nextLine().trim();

        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine().trim());

        System.out.print("Введите дату смерти (гггг-мм-дд) или оставьте пустым: ");
        String deathDateString = scanner.nextLine().trim();
        LocalDate deathDate = deathDateString.isEmpty() ? null : LocalDate.parse(deathDateString);

        Person person = new Person(name, gender, birthDate, deathDate);
        familyTree.addNode(person);
    }

    private void displayTree() {
        for (Person person : familyTree) {
            System.out.println(person.getName() + " (" + person.getBirthDate() + ")");
        }
    }

    private void sortByName() {
        Person.sortByName();
    }

    private void sortByBirthDate() {
        Person.sortByBirthDate();
    }

    private void saveTree() {
        System.out.print("Введите имя файла для сохранения: ");
        String fileName = scanner.nextLine().trim();
        try {
            familyTreeIO.writeToFile(familyTree, fileName);
            System.out.println("Дерево сохранено в " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева: " + e.getMessage());
        }
    }

    private void loadTree() {
        System.out.print("Введите имя файла для загрузки: ");
        String fileName = scanner.nextLine().trim();
        try {
            familyTree = (FamilyTree) familyTreeIO.readFromFile(fileName);
            System.out.println("Дерево загружено из " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке дерева: " + e.getMessage());
        }
    }
}

