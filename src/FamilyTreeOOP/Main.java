package FamilyTreeOOP;

import FamilyTreeOOP.Family.FamilyTree;
import FamilyTreeOOP.human.Gender;
import FamilyTreeOOP.human.Human;
import FamilyTreeOOP.writer.FileHandler;
import FamilyTreeOOP.writer.Writable;

import javax.swing.tree.TreeNode;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/FamilyTreeOOP/Family/tree.txt";
        FamilyTree tree = testTree();
        // FamilyTree tree = load(filePath);
        System.out.println(tree);

        save(tree, filePath);
    }

    private static FamilyTree load(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree tree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }

    public static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human oxana = new Human("Оксана", Gender.Female, LocalDate.of(1978, 9, 20));
        Human alexey = new Human("Алексей", Gender.Male, LocalDate.of(1975,9,10));
        tree.add((TreeNode) oxana);
        tree.add((TreeNode) alexey);
        tree.setWedding(oxana.getId(), alexey.getId());

        return tree;
    }

}
