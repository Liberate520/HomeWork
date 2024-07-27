package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.family_tree.TreeNode;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    //    private static FamilyTree tree;
    private static FamilyTree<Human> familyTree; // Используем тип Human

    public static void main(String[] args) {
        String filePath = "scr/family_tree/writer";

        familyTree = read(filePath);
        System.out.println(familyTree);

        FamilyTree<Human> testTree = createTestTree(); // Используем другое имя для тестового дерева
        System.out.println(testTree);

        save(testTree, filePath);
    }

    static FamilyTree<Human> read(String filePath) {
        FileHandler fileHandler = new FileHandler();
        try {
            return (FamilyTree<Human>) fileHandler.read(filePath);
        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new FamilyTree<>(); // Возвращаем пустое дерево в случае ошибки
        }
    }

    static void save(FamilyTree<Human> familyTree, String filePath) {
        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.save(familyTree, filePath);
        } catch (Exception e) {
            System.err.println("Error saving the file: " + e.getMessage());
        }
    }

    static FamilyTree<Human> createTestTree() {
        FamilyTree<Human> tree = new FamilyTree<>(); // Указываем тип Human

        Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(2000, 3, 3));
        Human iana = new Human("Iana", Gender.Female, LocalDate.of(2000, 8, 9));
        Human child1 = new Human("Elena", Gender.Female, LocalDate.of(2022, 3, 7));
        Human child2 = new Human("Igor", Gender.Male, LocalDate.of(2024, 5, 4));

        tree.add(ivan); // Не нужно явное приведение типов
        tree.add(iana);
        tree.add(child1);
        tree.add(child2);

        return tree;
    }
}
