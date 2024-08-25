package Homework4_OOP.WritersClasses;

import Homework4_OOP.Human.Human;
import Homework4_OOP.MVP.View;

import java.util.List;
import java.util.Scanner;

public class UserInterface implements View {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("1- Добавить человека");
        System.out.println("2- Поиск по имени");
        System.out.println("3- Удаление по ID");
        System.out.println("4- Вывод Древа");
        System.out.println("5- Выход");
        System.out.print("Выберите из предложенного: ");
    }

    @Override
    public int getUserChoice() {
        return scanner.nextInt();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayHumans(List<Human> humans) {
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
