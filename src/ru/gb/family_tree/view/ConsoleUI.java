package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("\033 [H\033 [2J");
        int a = LocalDateTime.now().getHour();
        if (a >= 5 && a < 12) {
            System.out.println("Доброе утро!");
        } else if (a >= 12 && a < 18) {
            System.out.println("Добрый день!");
        } else if (a >= 18 && a <= 23) {
            System.out.println("Добрый Вечер!");
        } else {
            System.out.println("Добрая ночь!");
        }
        String choise1, choise2, choise3;
        do {
            System.out.println("Выберите раздел:");
            System.out.println("1. Редактирование элементов");
            System.out.println("2. Редактирование дерева");
            System.out.println("3. Завершить работу");
            choise1 = scanner.nextLine();
            switch (choise1) {
                case "1":
                    System.out.println("\033 [H\033 [2J");
                    System.out.println("Выберите команду:");
                    System.out.println("1. Создать шаблон");
                    System.out.println("2. Удалить шаблон");
                    System.out.println("3. Дополнить шаблон");
                    System.out.println("3. Посмотреть список шаблонов");

                    choise2 = scanner.nextLine();
                case "2":
                    System.out.println("\033 [H\033 [2J");
                    System.out.println("Выберите команду:");
                    System.out.println("1. Добавить шаблон в дерево:");
                    System.out.println("2. Удалить шаблон из дерева:");
                    System.out.println("3. Выбрать метод сортировки:");
                    System.out.println("4. Посмотреть текущее дерево:");
                case "3":
                    System.out.println("\033 [H\033 [2J");
                    int a = LocalDateTime.now().getHour();
                    if (a >= 5 && a < 12) {
                        System.out.println("Доброго утра!");
                    } else if (a >= 12 && a < 18) {
                        System.out.println("Доброго дня!");
                    } else if (a >= 18 && a <= 23) {
                        System.out.println("Доброго вечера!");
                    } else {
                        System.out.println("Доброй ночи!");
                    }
                default:
                    System.out.println("Некорректный выбор, попробуйте ещё раз!");
                    choise1 ="999";
            }
        } while (choise1 != "999");

    }
    @Override
    public void printAnswer(String answer) {

    }
}
