package View;

import model.Service;
import model.entity.Gender;
import model.entity.Person;
import presenter.Presenter;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner = new Scanner(System.in);
    private Presenter presenter;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        menu();
    }

    public void menu(){
        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить пользователя в дерево");
            System.out.println("2. Добавить отношения пользователя с кем-то");
            System.out.println("3. Отобразить дерево");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // считываем перевод строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.println("Введите имя пользователя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите пол пользователя (Male/Female):");
                    Gender gender = Gender.valueOf(scanner.nextLine());
                    System.out.println("Введите год рождения пользователя (гггг-мм-дд):");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                    presenter.addPerson(name,gender,birthDate);
                    System.out.println("Пользователь успешно добавлен в дерево.");
                    break;
                case 2:
                    System.out.println("Введите имя родителя:");
                    String parentName = scanner.nextLine();
                    System.out.println("Введите имя ребенка:");
                    String childName = scanner.nextLine();
                    presenter.addRelationship(parentName,childName);
                    System.out.println("Отношения успешно добавлены.");
                    break;
                case 3:
                    System.out.println("Дерево:");
                    presenter.showTree();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите существующее действие.");
                    break;
            }
        }
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
