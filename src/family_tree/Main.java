package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.family_tree.TreeRoot;
import family_tree.human.Human;
import family_tree.human.Sex;
import family_tree.save_read.FileHandler;
import family_tree.save_read.WriteRead;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String pathName = "src/family_tree/new_tree.txt";
        FamilyTree newTree = tryTree();
        // FamilyTree newTree = read(pathName);
        System.out.println(newTree);
        save(newTree, pathName);
    }

    private static FamilyTree read(String pathName) {
        WriteRead writeRead = new FileHandler();
        return (FamilyTree) writeRead.read(pathName);
    }

    private static void save(FamilyTree newTree, String pathName) {
        WriteRead writeRead = new FileHandler();
        writeRead.save(newTree, pathName);
    }

    private static FamilyTree tryTree() {
        FamilyTree newTree = new FamilyTree();

        Human sergey = new Human("Сергей", "Попов",
                LocalDate.of(1976, 4, 6), Sex.male);
        Human julia = new Human("Юлия", "Попова",
                LocalDate.of(1976, 4, 6), Sex.female);

        newTree.add(sergey);
        newTree.add(julia);

        Human liza = new Human("Елизавета", "Попова",
                LocalDate.of(2011, 7, 3), Sex.female, sergey, julia);

        newTree.add(liza);

        return newTree;
    }
}
