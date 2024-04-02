package src;

import src.family_tree.FamilyTree;
import src.human.Gender;
import src.human.Human;
import src.save_family_tree.FileHandler;
import src.save_family_tree.Writable;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileHandler fh = new FileHandler();
//        Writable tree = fh.loadTree();

        FamilyTree tree = myFamilyTree();
        System.out.println(tree);

        fh.saveTree(tree);
    }

    /**
     * Initial initiation family tree.
     *
     * @return the family tree
     */
    static FamilyTree myFamilyTree() {
        FamilyTree tree = new FamilyTree();

        Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(1945, 5, 28));
        ivan.setDeathDate(LocalDate.of(2021, 8, 22));
        Human zoia = new Human("Zoia", Gender.Female, LocalDate.of(1950, 1, 1));
        zoia.setDeathDate(LocalDate.of(2021, 2, 19));

        tree.add(ivan);
        tree.add(zoia);
        tree.setWedding(ivan, zoia);

        Human kostia = new Human("Kostia", Gender.Male, LocalDate.of(1973, 12, 13),
                null, ivan, zoia);
        tree.add(kostia);

        return tree;
    }
}