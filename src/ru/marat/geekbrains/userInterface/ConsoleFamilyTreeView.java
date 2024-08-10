package ru.marat.geekbrains.userInterface;

import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private final Scanner scanner;

    public ConsoleFamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayFamilyTree(String treeRepresentation) {
        System.out.println(treeRepresentation);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
}
