package familytree.ui;

import familytree.io.FileDataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private FamilyTree<Person> familyTree;
    private FileDataHandler fileDataHandler;
    private Scanner scanner;

    public UserInterface(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
        this.fileDataHandler = new FileDataHandler();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Выберите команду: ");
            System.out.println("1 - Добавить нового члена");
            System.out.println("2 - Найти по имени");
            System.out.println("3 - Добавить родительско-детскую связь");
            System.out.println("4 - Вывести всех членов, отсортированных по фамилии и имени");
            System.out.println("5 - Вывести всех членов, отсортированных по дате рождения");
            System.out.println("6 - Сохранить дерево в файл");
            System.out.println("7 - Загрузить дерево из файла");
            System.out.println("0 - Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    findMember();
                    break;
                case 3:
                    addParentChildRelationship();
                    break;
                case 4:
                    printSortedByName();
                    break;
                case 5:
                    printSortedByDateOfBirth();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
        }
    }
    private void addMember() {
        System.out.println("Введите фамилию:");
        String familyName = scanner.nextLine();
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите отчество:");
        String fatherName = scanner.nextLine();
        System.out.println("Введите пол (MALE/FEMALE):");
        String genderInput = scanner.nextLine();
        Person.Gender gender = Person.Gender.valueOf(genderInput.toUpperCase());
        System.out.println("Введите дату рождения (YYYY-MM-DD):");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        Person newPerson = new Person(familyName, firstName, fatherName, gender, dateOfBirth);
        familyTree.addMember(newPerson);
        System.out.println("Член семьи добавлен!");
    }

    private void findMember() {
        System.out.println("Введите фамилию:");
        String familyName = scanner.nextLine();
        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();
        System.out.println("Введите отчество:");
        String fatherName = scanner.nextLine();

        Person foundPerson = familyTree.findMemberByFullName(familyName, firstName, fatherName);
        if (foundPerson != null) {
            System.out.println("Найден член семьи: " + foundPerson);
        } else {
            System.out.println("Член семьи не найден.");
        }
    }

    private void addParentChildRelationship() {
        System.out.println("Введите данные родителя:");
        System.out.println("Фамилия:");
        String parentFamilyName = scanner.nextLine();
        System.out.println("Имя:");
        String parentFirstName = scanner.nextLine();
        System.out.println("Отчество:");
        String parentFatherName = scanner.nextLine();

        System.out.println("Введите данные ребенка:");
        System.out.println("Фамилия:");
        String childFamilyName = scanner.nextLine();
        System.out.println("Имя:");
        String childFirstName = scanner.nextLine();
        System.out.println("Отчество:");
        String childFatherName = scanner.nextLine();

        familyTree.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
        System.out.println("Родительско-детская связь добавлена!");
    }

    private void printSortedByName() {
        List<Person> sortedByName = familyTree.getSortedByName();
        for (Person person : sortedByName) {
            System.out.println(person);
        }
    }

    private void printSortedByDateOfBirth() {
        List<Person> sortedByDate = familyTree.getSortedByDateOfBirth();
        for (Person person : sortedByDate) {
            System.out.println(person);
        }
    }

    private void saveToFile() {
        try {
            fileDataHandler.saveToFile("familyTree.dat", familyTree);
            System.out.println("Дерево сохранено успешно!");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try {
            FamilyTree<Person> loadedFamilyTree = fileDataHandler.loadFromFile("familyTree.dat");
            familyTree = loadedFamilyTree;
            System.out.println("Дерево загружено успешно!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        }
    }
}