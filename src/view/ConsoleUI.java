
package view;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;
import view.commands.*;

import java.time.LocalDate;
import java.util.Scanner;
import model.service.Service;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean isWorking;
    private MainMenu mainMenu;
    private Service service;

    public ConsoleUI(Service service) {
        this.service = service;
        this.presenter = new Presenter(this);
        this.scanner = new Scanner(System.in);
        this.isWorking = true;
        this.mainMenu = new MainMenu(this, service); // Передаем service
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать!");
        while (isWorking) {
            System.out.println(mainMenu.printMenu());
            String choice = scanner.nextLine();
            mainMenu.execute(choice);
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void addMember() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите пол (Male/Female):");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        presenter.addHuman(name, gender, birthDate);
    }


    public void addChild() {
        System.out.println("Введите ID родителя:");
        long parentId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите имя ребёнка:");
        String name = scanner.nextLine();
        System.out.println("Введите пол ребёнка (Male/Female):");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения ребёнка (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        boolean added = service.addChild(parentId, name, gender, birthDate);
        if (added) {
            System.out.println("Ребёнок успешно добавлен.");
        } else {
            System.out.println("Не удалось добавить ребёнка.");
        }
    }

    public void loadTree() {
        System.out.println("Введите путь к файлу:");
        String path = scanner.nextLine();
        presenter.loadTree(path);
    }

    public void saveTree() {
        System.out.println("Введите путь к файлу:");
        String path = scanner.nextLine();
        presenter.saveTree(path);
    }

    public void setWedding() {
        System.out.println("Введите ID первого человека:");
        long id1 = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID второго человека:");
        long id2 = Long.parseLong(scanner.nextLine());
        presenter.setWedding(id1, id2);
    }

    public void setDivorce() {
        System.out.println("Введите ID первого человека:");
        long id1 = Long.parseLong(scanner.nextLine());
        System.out.println("Введите ID второго человека:");
        long id2 = Long.parseLong(scanner.nextLine());
        presenter.setDivorce(id1, id2);
    }

    public void finish() {
        isWorking = false;
        System.out.println("До свидания!");
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Human getParentById(long parentId) {
        return service.getTree().getById(parentId);
    }
}

