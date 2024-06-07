package FamTree;

import java.time.LocalDate;

import FamTree.ft.FamilyTree;
import FamTree.human.Human;
import FamTree.writer.FileHandler;

public class Main {
    public static void main(String[] args) {

        String filePath = "tree.txt";

        FamilyTree tree = read(filePath);
//        FamilyTree tree = testTree();
        System.out.println(tree);

//        save(tree, filePath);
    }

    static FamilyTree read(String filePath) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    static void save(FamilyTree tree, String filePath) {
        FileHandler  fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    static FamilyTree testTree(){
                FamilyTree tree = new FamilyTree();

        Human vas   = new Human("Василий", Gender.Male, LocalDate.of(1966,12,12));
        Human georg = new Human("Георгий", Gender.Male, LocalDate.of(1955,11,11));
        Human sveta = new Human("Светлана", Gender.Female, LocalDate.of(1955,11,11));

        tree.add(vas);
        tree.add(georg);
        tree.add(sveta);

        System.out.println(tree);
        return tree;
    }
}
