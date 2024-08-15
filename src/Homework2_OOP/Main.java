package Homework2_OOP;


import java.time.LocalDate;



public class Main {

    public static void main(String[] args) {
        FamilyTree tree = load("save.txt");
        save(tree, "save.txt");
        System.out.println(tree);
    }

    private static FamilyTree load(String filename) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filename);
    }

    private static void save(FamilyTree familyTree, String filename) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filename);
    }

    private static FamilyTree famTree() {
        FamilyTree tree = new FamilyTree();

        Human first = new Human("Aleks", Gender.Male, LocalDate.of(1985, 1, 19));
        Human second = new Human("Marina", Gender.Female, LocalDate.of(1996, 10, 30));

        tree.add(first);
        tree.add(second);
        tree.setWedding(first, second);

        Human child1 = new Human("Dmitry", Gender.Male, LocalDate.of(2008, 1, 10), first, second);

        tree.add(child1);
        return tree;
    }
}
