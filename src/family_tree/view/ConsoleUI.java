package family_tree.view;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.family_tree.TreeRoot;
import family_tree.model.human.Human;
import family_tree.model.human.Sex;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в семейное древо!");

        while (work) {
            System.out.println("1. Добавить в семейное древо");
            System.out.println("2. Вывести семейное древо");
            System.out.println("3. Отсортировать древо по имени");
            System.out.println("4. Отсортировать древо по фамилии");
            System.out.println("5. Выход");

            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    printTree();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortBySurName();
                    break;
                case "5":
                    endChoice();
                    break;
                default:
                    System.out.println("Неверный ввод, повторите:");
            }
        }
    }

    private void endChoice() {
        work = false;
        System.out.println("Пока!");
    }

    private void sortBySurName() {
        presenter.sortBySurName();
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void printTree() {
        presenter.printTree();
    }

    private void addHuman() {
        System.out.println("Укажите нового члена семьи:");
        String objectName = scanner.nextLine();
        System.out.println("Укажите имя члена семьи:");
        String name = scanner.nextLine();
        System.out.println("Укажите фамилию члена семьи:");
        String surName = scanner.nextLine();
        System.out.println("Укажите дату рождения [dd.MM.yyyy]:");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(str, dtf);
        System.out.println("Укажите пол, male/female:");
        String sex = scanner.nextLine();

        if (sex.equals("male")) {
            Human human = new Human(name, surName,
                    dateOfBirth, Sex.male);
            human.setName(objectName);
            presenter.add(human);
        } else {
            if (sex.equals("female")) {
                Human human = new Human(name, surName,
                        dateOfBirth, Sex.female);
                human.setName(objectName);
                presenter.add(human);
            } else System.out.println("Пол введен неправильно");
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
