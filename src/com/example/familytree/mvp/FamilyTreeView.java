package com.example.familytree.mvp;

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

    public void displayTree(List<?> tree) {
        for (Object person : tree) {
            System.out.println(person);
        }
    }
}
