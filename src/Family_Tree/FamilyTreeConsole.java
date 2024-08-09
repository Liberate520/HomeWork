package Family_Tree;

import java.time.LocalDate;
import java.util.Scanner;

public class FamilyTreeConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private final FamilyTreePresenter presenter;
    private final FamilyTreeConsoleView view;

    public FamilyTreeConsole(FamilyTreePresenter presenter, FamilyTreeConsoleView view) {
        this.presenter = presenter;
        this.view = view;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            view.displayMenu();
            int option = getUserChoice();

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

    private int getUserChoice() {
        int option = scanner.nextInt();
        scanner.nextLine(); // Потребление символа новой строки
        return option;
    }

    private void addPerson() {
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

    private void findPerson() {
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

    private void saveTree() {
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        presenter.saveToFile(fileName);
        System.out.println("Дерево сохранено в файл " + fileName);
    }

    private void loadTree() {
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        presenter.loadFromFile(fileName);
        System.out.println("Дерево загружено из файла " + fileName);
    }

    private void printTree() {
        System.out.println("Текущее содержимое дерева:");
        System.out.println(presenter.getPeople());
    }

    public static void main(String[] args) {
        FamilyTree<Family_Tree.Person> familyTree = new FamilyTree<>();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree);
        FamilyTreeConsoleView view = new FamilyTreeConsoleView(presenter);
        FamilyTreeConsole console = new FamilyTreeConsole(presenter, view);

        console.start();
    }
}
