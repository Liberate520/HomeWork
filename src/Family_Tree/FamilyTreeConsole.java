package Family_Tree;

import java.time.LocalDate;
import java.util.Scanner;

public class FamilyTreeConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static FamilyTreePresenter presenter;

    public static void main(String[] args) {
        presenter = new FamilyTreePresenter(new FamilyTree<Family_Tree.Person>(), new FamilyTreeConsoleView(presenter));

        boolean exit = false;
        while (!exit) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Найти человека");
            System.out.println("3. Сохранить дерево в файл");
            System.out.println("4. Загрузить дерево из файла");
            System.out.println("5. Вывести дерево");
            System.out.println("6. Выйти");

            int option = scanner.nextInt();
            scanner.nextLine(); // Потребление символа новой строки

            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPerson();
                    break;
                case 3:
                    saveTree();
                    break;
                case 4:
                    loadTree();
                    break;
                case 5:
                    printTree();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void addPerson() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите пол (0 для Мужского, 1 для Женского):");
        int gender = scanner.nextInt();
        scanner.nextLine(); // Потребление символа новой строки
        System.out.println("Введите год рождения:");
        int year = scanner.nextInt();
        System.out.println("Введите месяц рождения:");
        int month = scanner.nextInt();
        System.out.println("Введите день рождения:");
        int day = scanner.nextInt();
        LocalDate birthDate = LocalDate.of(year, month, day);

        presenter.addPerson(name, "", gender, birthDate);
    }

    private static void findPerson() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        Family_Tree.Person person = presenter.findPersonByName(name, "");
        if (person != null) {
            System.out.println("Человек найден:");
            System.out.println(person);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private static void saveTree() {
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        presenter.saveToFile(fileName);
        System.out.println("Дерево сохранено в файл " + fileName);
    }

    private static void loadTree() {
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        presenter.loadFromFile(fileName);
        System.out.println("Дерево загружено из файла " + fileName);
    }

    private static void printTree() {
        System.out.println("Текущее содержимое дерева:");
        System.out.println(presenter.getPeople());
    }
}