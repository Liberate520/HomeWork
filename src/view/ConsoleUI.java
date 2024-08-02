package view;

import model.FamilyTree;
import model.human.Gender;
import model.human.Person;
import model.writer.FileHandler;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private FamilyTree<Person> familyTree;
    public final String filePath = "src/model/writer/FamilyTree.txt";

    public ConsoleUI(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+-------------------------------------+");
            System.out.println("| Выберите пункт меню приложения      |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1. Добавить элемент в дерево        |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 2. Найти элемент дерева             |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 3. Найти детей родителя             |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 4. Сортировка элементов по имени    |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 5. Сортировка элементов по возрасту |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 6. Сохранить данные                 |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 7. Загрузить данные                 |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 8. Завершить работу приложения      |");
            System.out.println("+-------------------------------------+");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    getPerson(scanner);
                    break;
                case 3:
                    getChildren(scanner);
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    sortByAge();
                    break;
                case 6:
                    save();
                    break;
                case 7:
                    load();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }

    private void addPerson(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Введите дату рождения (в формате гггг-мм-дд): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        Person person = new Person(name, age, gender);
        person.setBirthDate(birthDate);

        familyTree.addElement(name, person);
        System.out.println("Элемент добавлен.");
    }

    private void getPerson(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        Person person = familyTree.getElement(name);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Элемент не найден.");
        }
    }

    private void getChildren(Scanner scanner) {
        System.out.print("Введите имя родителя: ");
        String name = scanner.nextLine();

        Person parent = familyTree.getElement(name);
        if (parent != null) {
            List<Person> children = parent.getChildren();
            if (children.isEmpty()) {
                System.out.println("У данного родителя нет детей.");
            } else {
                for (Person child : children) {
                    System.out.println(child);
                }
            }
        } else {
            System.out.println("Элемент не найден.");
        }
    }

    private void sortByName() {
        List<Person> sortedByName = familyTree.personSortedByName();
        for (Person person : sortedByName) {
            System.out.println(person);
        }
    }

    private void sortByAge() {
        List<Person> sortedByAge = familyTree.personSortedByBirthDay();
        for (Person person : sortedByAge) {
            System.out.println(person);
        }
    }

    private void save() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

    private void load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        this.familyTree = (FamilyTree<Person>) fileHandler.read();
    }
}