package com.example.familytree.mvp;

import com.example.familytree.model.Person;
import java.util.List;
import java.util.Scanner;

public class FamilyTreeView {
    private Scanner scanner;

    public FamilyTreeView() {
        scanner = new Scanner(System.in);
    }

    public int getPersonIdInput() {
        System.out.print("Введите ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getPersonNameInput() {
        System.out.print("Введите имя: ");
        return scanner.nextLine();
    }

    public String getPersonBirthDateInput() {
        System.out.print("Введите дату рождения (ДД-ММ-ГГГГ): ");
        return scanner.nextLine();
    }

    public String getPersonGenderInput() {
        System.out.print("Введите пол: ");
        return scanner.nextLine();
    }

    public int getParentIdInput() {
        System.out.print("Введите ID родителя: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getChildIdInput() {
        System.out.print("Введите ID ребенка: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTree(List<Person> tree) {
        for (Person person : tree) {
            System.out.println("ID: " + person.getId() + " Имя: " + person.getName() +
                    " Дата рождения: " + person.getBirthDate() +
                    " Пол: " + person.getGender() +
                    " Возраст: " + person.getAge());

            List<Person> children = person.getChildren();
            if (!children.isEmpty()) {
                System.out.println("Дети:");
                for (Person child : children) {
                    System.out.println("  - " + child.getName() + " (ID: " + child.getId() + ")");
                }
            } else {
                System.out.println("Дети: нет");
            }

        }
    }
}
