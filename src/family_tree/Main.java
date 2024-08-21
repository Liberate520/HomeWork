package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.time.LocalDate;

import static java.lang.System.load;

public class Main {
    final static String filepath = "src/family_tree/writer/tree.txt";
    public static void main(String[] args) {

        FamilyTree familyTree = load();
//        FamilyTree familyTree = testTree();
        save(familyTree);


        System.out.println(familyTree);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filepath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filepath);
        fileHandler.save(familyTree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1990, 1, 1));
        Human dasha = new Human("Дарья", Gender.Female, LocalDate.of(1991, 2, 2));

        tree.add(vasya);
        tree.add(dasha);
        tree.setWedding(vasya, dasha);

        Human oleg = new Human("Олег", Gender.Male, LocalDate.of(1997, 9, 9));

        tree.add(oleg);

        Human larisa = new Human("Лариса", Gender.Female, LocalDate.of(1960, 3, 3));
        larisa.addChild(oleg);
        tree.add(larisa);

        return tree;
    }
}
