package View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Model.Human;

public class FamilyTreeConsoleView implements FamilyTreeView {
    private Scanner scanner;

    public FamilyTreeConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayFamilyTree(List<Human> familyMembers) {
        System.out.println("Семейное древо:");
        for (Human member : familyMembers) {
            System.out.println(member);
        }
    }

    @Override
    public String getNameForChildren() {
        System.out.println("Введите имя для отображения детей:");
        return scanner.nextLine();
    }

    @Override
    public String getNameForParents() {
        System.out.println("Введите имя для отображения родителей:");
        return scanner.nextLine();
    }

    @Override
    public void displayChildren(String name, List<Human> children) {
        if (children != null && !children.isEmpty()) {
            System.out.println("Дети " + name + ":");
            for (Human child : children) {
                System.out.println(child);
            }
        } else {
            System.out.println("У данного человека нет детей или человек с именем " + name + " не найден.");
        }
    }

    @Override
    public void displayParents(String name, List<Human> parents) {
        if (parents != null && !parents.isEmpty()) {
            System.out.println("Родители " + name + ":");
            for (Human parent : parents) {
                System.out.println(parent + ", возраст: " + parent.getAgeAt(LocalDate.now()));
            }
        } else {
            System.out.println("Человек с именем " + name + " не найден.");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
