package view;

import model.human.Gender;
import model.service.Service;
import model.writable.FileHandler;
import presenter.Presenter;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View, Serializable {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добрый день! Выберите действие:");
        while (work) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
//            todo    метод проверки на валидность strChoice
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }
    }
    private void error() {
        System.out.println("Введено неверное значение");
    }
    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamalyTreeInfo() {
        presenter.getFamalyTreeInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();

        System.out.println("Укажите год рождения");
        String strYear = scanner.nextLine();
        int year = Integer.parseInt(strYear);

        System.out.println("Укажите месяц рождения");
        String strMonth = scanner.nextLine();
        int month = Integer.parseInt(strMonth);

        System.out.println("Укажите дату рождения");
        String strDate = scanner.nextLine();
        int date = Integer.parseInt(strDate);
        LocalDate localDate = LocalDate.of(year, month, date);

        System.out.println("Укажите пол");
        String strGender = scanner.nextLine();
        Gender gender = Gender.valueOf(strGender);

        presenter.addHuman(name, localDate, gender);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
