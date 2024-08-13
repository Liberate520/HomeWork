package view;

import model.human.Human;
import presenter.Presenter;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUi implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);

    }

    @Override
    public void start() {
        System.out.println("Приветствие");
        while (work) {
            System.out.println("1. Добавить человека в семейное древо");
            System.out.println("2. Получить список людей в семейном древе");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Завершение работы");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    getHumansList();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByAge();
                    break;
                case "5":
                    finish();
                    break;
                default:
                    System.out.println("Не верно введено значение");
            }
        }
    }

    private void finish() {
        work = false;
        scanner.close();
        System.out.println("До новых встреч!");
    }

    private void sortByAge() {
        presenter.sortByAge();
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void getHumansList() {
        presenter.getHumansList();
    }

    private void add() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст человека");
        String ageStr = scanner.nextLine();
        presenter.add();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void printAnswer(List<Human> answer) {
        System.out.println(answer);
    }
}
