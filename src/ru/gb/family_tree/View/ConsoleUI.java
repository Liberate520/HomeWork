package ru.gb.family_tree.View;

import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.Presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private MainMenu mainMenu;
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    @Override
    public void start() {

        while (work) {
            System.out.println(mainMenu.menu());
            String line = scanner.nextLine();
            try {
                int choise = Integer.parseInt(line);
                if(choise <= mainMenu.size()) {
                    mainMenu.choice(choise);
                }else{
                    System.out.println("Нет такой функции меню");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вводить нужно числа");
            }
        }

    }

    public void finish() {
        work = false;
    }

    public void info() {
        presenter.info();
    }

    public void getByName() {
        presenter.getByName();
    }

    public void getByGender() {
        presenter.getByGender();
    }

    public void getByDateOfBirth() {
        presenter.getByDateOfBirth();
    }

    public void getByAge() {
        presenter.getByAge();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public ConsoleUI() {
        mainMenu = new MainMenu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }
}
