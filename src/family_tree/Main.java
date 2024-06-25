package family_tree;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.save_read.FileHandler;
import family_tree.model.save_read.WriteRead;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

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

        View view = new ConsoleUI();
        view.start();
        return newTree;
    }
}
