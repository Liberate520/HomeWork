package family_tree.view;

import family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void Start() {
        System.out.println("Добро пожаловать в семейное древо!");

        while (true) {
            System.out.println("1. Добавить в семейное древо");
            System.out.println("2. Вывести семейное древо");
            System.out.println("3. Отсортировать древо по имени");
            System.out.println("4. Отсортировать древо по фамилии");
            System.out.println("5. Выход");

            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Неверный ввод, повторите:");
            }
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
