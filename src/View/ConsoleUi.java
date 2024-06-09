package View;

import Model.Organisms.Mammals.Persons.Enums.Gender;
import Presentor.Presentor;
import View.AllMenu.MainMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View {
    private Presentor presentor;
    private MainMenu mainMenu;
    Scanner scanner;
    Boolean flag;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        presentor = new Presentor(this);
        mainMenu = new MainMenu(this);
        flag = true;
        load();
    }
    @Override
    public void start() {
        while (flag == true){
            System.out.println(mainMenu.getMenu());
            int choice = scanner.nextInt();
            mainMenu.choice(choice);
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println("text");
    }

    //Методы добавления
    public void addPerson() {
        System.out.println("Введите ФИО: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (м или ж):");
        String gender = scanner.nextLine().toLowerCase();
        if (gender.equals('м'))
            presentor.addPerson(name, Gender.male);
        else
            presentor.addPerson(name, Gender.female);
    }
    public void addParent() {
        System.out.println("Введите индекс ребенка: ");
        int index = scanner.nextInt();
        System.out.println("Введите индекс родителя: ");
        int indexParent = scanner.nextInt();
        presentor.addParent(index, indexParent);
    }
    public void addChield() {
        System.out.println("Введите индекс родителя: ");
        int index = scanner.nextInt();
        System.out.println("Введите индекс ребенка: ");
        int indexChield = scanner.nextInt();
        presentor.addChield(index, indexChield);
    }
    public void addBirthday() {
        System.out.println("Введите номер в базе (индекс): ");
        int index = scanner.nextInt();
        System.out.println("Введите год рождения: ");
        int year= scanner.nextInt();
        System.out.println("Введите месяц: ");
        int month= scanner.nextInt();
        System.out.println("Введите день: ");
        int day= scanner.nextInt();
        LocalDate birthday = LocalDate.of(year, month, day);
        presentor.addBirthday(birthday, index);
    }
    public void addDeathDate() {
        System.out.println("Введите номер в базе (индекс): ");
        int index = scanner.nextInt();
        System.out.println("Введите год смерти: ");
        int year= scanner.nextInt();
        System.out.println("Введите месяц: ");
        int month= scanner.nextInt();
        System.out.println("Введите день: ");
        int day= scanner.nextInt();
        LocalDate deathDate = LocalDate.of(year, month, day);
        presentor.addDeathDate(deathDate, index);
    }
    //методы сортировки
    public void sortByBirthday() {
        presentor.sortByBirthday();
    }
    public void sortByName() {
        presentor.sortedByName();
    }
    public void getPersonOnSurname() {
        System.out.println("Введи фамилию искомого человека: ");
        String name = scanner.nextLine();
        System.out.println("Результаты поиска:\n");
        presentor.getPersonOnSurname(name);
    }

    public void getFullPerson() {
        int index = scanner.nextInt();
        presentor.getFullPerson(index);
    }
    public void getAllFamily() {
        presentor.getAllFamily();
    }
    public void getAllIndices() {
        presentor.getAllIndices();
    }
    //методы сериализации
    public void save() {
        presentor.save();
    }
    public void load() {
        presentor.load();
    }

    public void end() {
        save();
        flag = false;
    }
}