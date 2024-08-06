package ru.gb.family_tree.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView<T> implements FamilyTreeView<T> {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showAllMembers(List<T> members) {
        for (T member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showMember(T member) {
        System.out.println(member);
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
