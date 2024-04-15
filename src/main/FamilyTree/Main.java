package FamilyTree;

import FamilyTree.Model.FileHandler;
import FamilyTree.Model.Human;
import FamilyTree.Model.Tree.FamilyTree;
import FamilyTree.View.ConsoleUI;
import FamilyTree.View.View;


import java.io.File;
import java.io.IOException;



public class Main {

    public static void main(String[] args) throws IOException {
        View consoleTree = new ConsoleUI();
        consoleTree.start();

    }


    private static void dataInputOutput(FamilyTree familyTree) {

        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, new File("archive.txt"));

        File file = new File("archive.txt");
        FamilyTree<Human> newTree = fileHandler.read(file);
        print(newTree, "\n Печать восстановленного дерева");

    }

    private static void print(FamilyTree<Human> tree, String mess) {
        System.out.println(mess);
        for (Human item : tree) {
            System.out.println(item.toString());
        }
    }
}
