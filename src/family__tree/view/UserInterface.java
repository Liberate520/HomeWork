package family__tree.view;

import family__tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface implements UserInterfaceView {
    private Presenter presenter;
    private Scanner scanner;

    public UserInterface(Presenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Введите команду (help для списка команд): ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    addHuman();
                    break;
                case "addchild":
                    addChild();
                    break;
                case "remove":
                    removeHuman();
                    break;
                case "find":
                    findHuman();
                    break;
                case "list":
                    listHumans();
                    break;
                case "showchildren":
                    showChildren();
                    break;
                case "showparents":
                    showParents();
                    break;
                case "sortbyname":
                    sortByName();
                    break;
                case "sortbyage":
                    sortByAge();
                    break;
                case "save":
                    saveTree();
                    break;
                case "load":
                    loadTree();
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    return;
                case "help":
                    printHelp();
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите 'help' для списка команд.");
            }
        }
    }

    private void addHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите пол (Male/Female): ");
        String gender = scanner.nextLine();
        presenter.addHuman(name, birthDate, gender);
    }

    private void addChild() {
        System.out.println("Введите имя родителя: ");
        String parentName = scanner.nextLine();
        System.out.println("Введите имя ребенка: ");
        String childName = scanner.nextLine();
        presenter.addChild(parentName, childName);
    }

    private void removeHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        presenter.removeHuman(name);
    }

    private void findHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        presenter.findHuman(name);
    }

    private void listHumans() {
        presenter.listHumans();
    }

    private void showChildren() {
        System.out.println("Введите имя родителя: ");
        String parentName = scanner.nextLine();
        presenter.showChildren(parentName);
    }

    private void showParents() {
        System.out.println("Введите имя ребенка: ");
        String childName = scanner.nextLine();
        presenter.showParents(childName);
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void sortByAge() {
        presenter.sortByAge();
    }

    private void saveTree() {
        presenter.saveTree();
    }

    private void loadTree() {
        presenter.loadTree();
    }

    private void printHelp() {
        System.out.println("Список команд:");
        System.out.println("add - добавить человека");
        System.out.println("addchild - добавить ребенка к родителю");
        System.out.println("remove - удалить человека");
        System.out.println("find - найти человека по имени");
        System.out.println("list - вывести список всех людей");
        System.out.println("showchildren - показать детей родителя");
        System.out.println("showparents - показать родителей ребенка");
        System.out.println("sortbyname - сортировать по имени");
        System.out.println("sortbyage - сортировать по возрасту");
        System.out.println("save - сохранить дерево");
        System.out.println("load - загрузить дерево");
        System.out.println("help - вывести список команд");
        System.out.println("exit - выйти из программы");
    }
}