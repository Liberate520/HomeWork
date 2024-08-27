package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI {
    private Presenter presenter;
    private final String filePath = "src/model/writer/FamilyTree.txt";

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    +-------------------------------------+
                    | 1. Добавить элемент в дерево        |
                    | 2. Найти элемент дерева             |
                    | 3. Найти детей родителя             |
                    | 4. Сортировка элементов по имени    |
                    | 5. Сортировка элементов по возрасту |
                    | 6. Сохранить данные                 |
                    | 7. Загрузить данные                 |
                    | 8. Завершить работу приложения      |
                    +-------------------------------------+
                    """);
            int command = scanner.nextInt();
            scanner.nextLine();
            handleCommand(command, scanner);
        }
    }

    private void handleCommand(int command, Scanner scanner) {
        switch (command) {
            case 1:
                presenter.addPerson(scanner);
            case 2:
                presenter.getPerson(scanner);
            case 3:
                presenter.getChildren(scanner);
            case 4:
                presenter.sortByName();
            case 5:
                presenter.sortByAge();
            case 6:
                presenter.save(filePath);
            case 7:
                presenter.load(filePath);
            case 8:
                System.out.println("Работа приложения успешно завершена!");
                break;
            default:
                System.out.println("Неверная команда");
        }
    }
}