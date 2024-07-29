package ru.gb.studygroup.view;

import ru.gb.studygroup.presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Ave, Caesar!");
        while (work) {
            System.out.println(menu.getMenu());
            String strChoose = scanner.nextLine();
            //проверка на валидность
            int choose = Integer.parseInt(strChoose);
            menu.execute(choose);
        }
    }

    public boolean checkChooseForNum(String strChoose) {
        if (strChoose.matches("[0-9]*")) {
            int choose = Integer.parseInt(strChoose);
            return choose >= 1 && choose <= menu.sizeMenu();
        }
        return false;
    }

    public void finish() {
        System.out.println("Завершение работы...");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getStudentListInfo() {
        presenter.getStudentListInfo();
    }

    public void addStudent() {
        System.out.println("Укажите имя студента: ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст студента: ");
        String ageStr = scanner.nextLine();
        //проверка ввода
        int age = Integer.parseInt(ageStr);
        presenter.addStudent(name, age);
    }

    @Override
    public void printAnswers(String answer) {
        System.out.println(answer);
    }

    public void save(){}

    public void load(){}
}
