package ru.gb.family_tree.view;

import ru.gb.family_tree.models.Human;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements FamilyTreeView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showAllMembers(List<Human> members) {
        for (Human member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showMember(Human member) {
        System.out.println(member);
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
