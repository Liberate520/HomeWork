package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean check;
    private MainMenu menu;

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void start() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        System.out.println("\nДобрый день! Выберите пункт меню:");
        while (check) {
            printMenu();
            check = choice();
        }
    }

    private boolean choice() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        if (choice > 0 && choice < menu.size() + 1) {
            menu.execute(choice);
        }
        if (choice == menu.size()) {
            return false;
        } else return true;
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        check = true;
        menu = new MainMenu(this);
    }

    public void addFirst() {
        if (presenter.addFirst()) {
            success();
        } else error();
    }

    public void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите число, соответствующее полу (1-Male, 2-Female): ");
        String genderStr = scanner.nextLine();

        String str = "";
        while (!str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            System.out.print("Введите дату рождения в формате 'YYYY-MM-DD': ");
            str = scanner.nextLine();
        }
        int year = Integer.parseInt(str.split("-")[0]);
        int month = Integer.parseInt(str.split("-")[1]);
        int day = Integer.parseInt(str.split("-")[2]);
        if (presenter.addHuman(name, genderStr, LocalDate.of(year, month, day))) {
            success();
        } else error();
    }

    public void wedding() {
        System.out.print("Введите id жениха: ");
        int id1 = checkId();
        System.out.print("Введите id невесты: ");
        int id2 = checkId();
        if (presenter.setWedding(id1, id2)) {
            success();
        } else error();
    }

    public void divorce() {
        System.out.print("Введите id мужа: ");
        int id1 = checkId();
        System.out.print("Введите id жены: ");
        int id2 = checkId();
        if (presenter.setDivorce(id1, id2)) {
            success();
        } else error();
    }

    public void addChild() {
        System.out.print("Введите ID родителя: ");
        int parentId = checkId();
        System.out.print("Введите ID ребенка: ");
        int childId = checkId();
        if (parentId == childId) {
            System.out.println("Id одинаковы. Данные не добавлены.");
        } else {
            if (presenter.addChild(parentId, childId)) {
                success();
            } else error();
        }
    }

    public void finish() {
        System.out.println("До свидания!");
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void saveTree() {
        presenter.saveTree();
    }

    public void loadSaveTree() {
        presenter.loadSaveTree();
    }

    public void sortById() {
        presenter.sortById();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void addDeathDate() {
        System.out.print("Введите Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        String str = "";
        while (!str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            System.out.print("Введите дату смерти в формате 'YYYY-MM-DD': ");
            str = scanner.nextLine();
        }
        int year = Integer.parseInt(str.split("-")[0]);
        int month = Integer.parseInt(str.split("-")[1]);
        int day = Integer.parseInt(str.split("-")[2]);
        if (presenter.setDeathDate(id, year, month, day)) {
            success();
        } else error();
    }

    public void addBirthDate() {
        System.out.print("Введите Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        String str = "";
        while (!str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            System.out.print("Введите дату рождения в формате 'YYYY-MM-DD': ");
            str = scanner.nextLine();
        }
        int year = Integer.parseInt(str.split("-")[0]);
        int month = Integer.parseInt(str.split("-")[1]);
        int day = Integer.parseInt(str.split("-")[2]);
        if (presenter.setBirthDate(id, year, month, day)) {
            success();
        } else error();
    }

    private int checkInt() {
        int value = 0;
        boolean i = true;
        while (i) {
            String text = scanner.nextLine();
            if (text.matches("[0-9]+")) {
                value = Integer.parseInt(text);
                i = false;
            } else {
                System.out.print("Неверное значение! Введите целое число: ");
            }
        }
        return value;
    }

    private int checkId() {
        int id;
        while (true) {
            id = checkInt();
            if (presenter.checkId(id)) {
                return id;
            } else System.out.print("Человек с таким id не найден. Введите другое значение id: ");
        }
    }

    private void success() {
        System.out.println("Данные успешно обновлены!\n");
    }

    private void error() {
        System.out.println("Данные не записаны!\n");
    }
}