package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private final Presenter presenter;
    private final Scanner scanner;
    private final MainMenu mainMenu;
    private boolean work;

    public ConsoleUI() {
        presenter = new Presenter();
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        work = true;
    }

    @Override
    public void start() {
        int menuPoint;
        while (work) {
            System.out.println(mainMenu.menu());
            //input = scanner.nextLine();
            //menuPoint = Integer.parseInt(input);
            menuPoint = scanner.nextInt();
            mainMenu.execute(menuPoint);
        }
    }

    public void getTreeInfo() {
        System.out.println("Список людей древа:");
        String result = presenter.getTreeInfo();
        printResult(result);
    }

    public void sortById() {
        System.out.println("Список людей древа (отсортированный по ID):");
        String result = presenter.sortById();
        printResult(result);
    }

    public void sortByName() {
        System.out.println("Список людей древа (отсортированный по имени):");
        String result = presenter.sortByName();
        printResult(result);
    }

    public void sortByAge() {
        System.out.println("Список людей древа (отсортированный по возрасту):");
        String result = presenter.sortByAge();
        printResult(result);
    }

    public void sortByBirthDay() {
        System.out.println("Список людей древа (отсортированный по дате рождения):");
        String result = presenter.sortByBirthDay();
        printResult(result);
    }

    public void getChildrenInfo() {
        System.out.println("Выберите id человека чтобы построть фамильное дерево:");
        String result = presenter.getChildrenInfo(scanner.nextInt());
        printResult(result);
    }

    public void addHuman() {
        //System.out.println("Введите имя:");
        //String name = scanner.nextLine();
        String name = "Евдокия Михайловна Романова";
        //System.out.println("Введите пол (М или Ж):");
        //String gender = scanner.nextLine();
        String gender = "Ж";
        //System.out.println("Введите дату рождения (в формате год-месяц-день):");
        //String birthDay = scanner.nextLine();
        String birthDay = "1637-02-20";
        String result = presenter.addHuman(name, gender, birthDay);
        printResult(result);
        //System.out.println("Человек добавлен в дерево.");
    }

    public void setHumanDeathDay() {
        System.out.println("Введите ID человека:");
        //int selectId = Integer.parseInt(scanner.nextLine());
        int id = 10;
        //System.out.println("Введите дату смерти (в формате год-месяц-день):");
        //String deathDay = scanner.nextLine();
        String deathDay = "1637-02-20";
        String result = presenter.setHumanDeathDay(id, deathDay);
        printResult(result);
        //System.out.println("Добавлена дата смерти.");
    }

    public void setHumanFather() {
        System.out.println("Введите ID ребенка:");
        //int idChildren = Integer.parseInt(scanner.nextLine());
        int idChildren = 10;
        System.out.println("Введите ID отца:");
        //int idFather = Integer.parseInt(scanner.nextLine());
        int idFather = 1;
        String result = presenter.setHumanFather(idChildren, idFather);
        printResult(result);
        //System.out.println("Отец добавлен.");
    }

    public void setHumanMother() {
        System.out.println("Введите ID ребенка:");
        //int idChildren = Integer.parseInt(scanner.nextLine());
        int idChildren = 10;
        System.out.println("Введите ID матери:");
        //int idMother = Integer.parseInt(scanner.nextLine());
        int idMother = 8;
        String result = presenter.setHumanMother(idChildren, idMother);
        printResult(result);
        //System.out.println("Мать добавлена.");
    }

    public void wedding() {
        System.out.println("Введите ID мужа:");
        //int idHusband = Integer.parseInt(scanner.nextLine());
        int idHusband = 1;
        System.out.println("Введите ID жены:");
        //int idWife = Integer.parseInt(scanner.nextLine());
        int idWife = 8;
        String result = presenter.wedding(idHusband, idWife);
        printResult(result);
        //System.out.println("Брак заключен.");
    }

    public void divorce() {
        System.out.println("Введите ID мужа:");
        //int idHusband = Integer.parseInt(scanner.nextLine());
        int idHusband = 1;
        System.out.println("Введите ID жены:");
        //int idWife = Integer.parseInt(scanner.nextLine());
        int idWife = 8;
        String result = presenter.divorce(idHusband, idWife);
        printResult(result);
        //System.out.println("Брак разторгнут.");
    }

    public void remove() {
        System.out.println("Введите ID человека:");
        //int id = Integer.parseInt(scanner.nextLine());
        int id = 10;
        String result = presenter.remove(id);
        printResult(result);
        //System.out.println("Человек удален и дерева.");
    }

    public void createFamilyTree() {
        System.out.println("Список людей древа:");
        String result = presenter.createFamilyTree();
        printResult(result);
        //System.out.println("Семейное древо создано.");
    }

    public void saveTree() {
        String result = presenter.saveTree();
        printResult(result);
        //System.out.println("Семейное древо сохранено в файл.");
    }

    public void restoreTree() {
        String result = presenter.restoreTree();
        printResult(result);
        //System.out.println("Семейное древо востановленно из файла.");
    }

    public void stop() {
        work = false;
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }
}
