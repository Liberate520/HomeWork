package com.example.familytree.mvp;

import com.example.familytree.model.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView extends FamilyTreeView {
    private Scanner scanner;

    public ConsoleFamilyTreeView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayTree(List<?> members) {
        for (Object member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getPersonNameInput() {
        System.out.print("Введите имя: ");
        return scanner.nextLine();
    }

    @Override
    public String getPersonBirthDateInput() {
        System.out.print("Введите дату рождения (ДД-ММ-ГГГГ): ");
        return scanner.nextLine();
    }

    @Override
    public String getPersonGenderInput() {
        System.out.print("Введите пол (Муж/Жен): ");
        return scanner.nextLine();
    }


    public int getParentIdInput() {
        System.out.print("Введите ID родителя: ");
        return scanner.nextInt();
    }

    public int getChildIdInput() {
        System.out.print("Введите ID ребенка: ");
        return scanner.nextInt();
    }
}
