package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // FamilyTree tree = testTree();
        FamilyTree tree = readTree();

        // saveTree(tree);

        System.out.println(tree);
    }

    private static FamilyTree readTree() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static void saveTree(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human john = new Human("John", "Doe", Gender.Male, LocalDate.of(1960, 5, 15),
                null, null, null);
        Human jane = new Human("Jane", "Doe", Gender.Female, LocalDate.of(1970, 8, 20),
                null, null, null);

        tree.add(john);
        tree.add(jane);
        tree.setWedding(john, jane);

        Human alice = new Human("Alice", "Doe", Gender.Female, LocalDate.of(1990, 2, 10),
                null, john, jane);
        Human bob = new Human("Bob", "Doe", Gender.Male, LocalDate.of(1995, 11, 30),
                null, john, jane);

        tree.add(alice);
        tree.add(bob);

        Human maria = new Human("Maria", "Doe", Gender.Female, LocalDate.of(1937, 4, 18));
        maria.addChild(john);

        tree.add(maria);

        return tree;
    }

}