package family_tree;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);

        // Добавление людей в дерево
        familyTree.addHuman("Alice", "01-01-1970");
        familyTree.addHuman("Bob", "01-01-2000");
        familyTree.addHuman("Charlie", "01-01-2005");

        // Установление родительско-детских отношений
        familyTree.addChild("Alice", "Bob");
        familyTree.addChild("Alice", "Charlie");

        // Исследование: получение детей определенного человека
        System.out.println("Введите имя человека, чтобы найти его детей:");
        String name = scanner.nextLine();

        List<Human> children = familyTree.getChildren(name);
        if (children != null) {
            System.out.println("Дети " + name + ":");
            for (Human child : children) {
                System.out.println("- " + child.getName());
            }
        } else {
            System.out.println(name + " не имеет детей или не существует в генеалогическом дереве.");
        }

        // Отображение всего генеалогического дерева
        System.out.println("\nПолное генеалогическое дерево:");
        familyTree.displayFamilyTree();

        scanner.close();
    }
}
