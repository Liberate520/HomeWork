package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
//          FamilyTree tree = readTree();

        saveTree(tree);

        FamilyTree familyTree = new FamilyTree();

        System.out.println(tree);
        familyTree.sortByBirthDate();
        familyTree.sortByName();

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

        Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(1980, 9, 17));
        Human daria = new Human("Daria", Gender.Female, LocalDate.of(1982, 3, 2));

        tree.add(ivan);
        tree.add(daria);
        tree.setWedding(ivan, daria);

        Human sasha = new Human("Alexander", Gender.Male, LocalDate.of(2001, 4, 24), ivan, daria);
        Human ira = new Human("Daria", Gender.Female, LocalDate.of(2003, 6, 11), ivan, daria);

        tree.add(sasha);
        tree.add(ira);

        Human grandma = new Human("Ludmila", Gender.Female, LocalDate.of(1957, 8, 26));
        grandma.addChild(ivan);

        tree.add(grandma);
        return tree;
    }
}
