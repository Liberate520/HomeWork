package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("Hi!");

        while (true) {
            System.out.println("1. Add human.");
            System.out.println("2. Print list humans.");
            System.out.println("3. Sort By Name.");
            System.out.println("4. Sort By Birth Date.");
            System.out.println("5. Sort By Gender.");
            System.out.println("6. End.");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    getHumanListInfo();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByBirthDate();
                    break;
                case "5":
                    sortByGender();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("ERROR");
            }
        }
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void getHumanListInfo() {
        presenter.getInfo();
    }

    private void addHuman() {
        System.out.println("Name human: ");
        String name = scanner.nextLine();
        System.out.println("Age human: ");
        String ageStr = scanner.nextLine();
        //проверка на валидность
        int age = Integer.parseInt(ageStr);
        presenter.addHuman(name, age);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
