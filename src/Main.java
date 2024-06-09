import java.time.LocalDate;

import Family_tree.FamilyTree;
import Family_tree.FileHandler;
import Family_tree.Human;
import Family_tree.Writable;

public class Main {

    public static void main(String[] args) { 
        String filPath = "test.txt";
        FamilyTree tree = testTree();
        System.out.println(tree);
        save(tree, filPath);
    }

    private static FamilyTree testTree() {
        FamilyTree familyTree = new FamilyTree();
        Human father = new Human("Victor", LocalDate.of(1961, 12, 19), LocalDate.of(0000, 1, 1), null, null, Family_tree.Gender.MALE);
        Human mother = new Human("Evgehiya", LocalDate.of(1964, 4, 7), LocalDate.of(2005, 12, 18), null, null, Family_tree.Gender.FEMALE);
        Human me = new Human("Maksim", LocalDate.of(1985, 4, 19), LocalDate.of(0000, 1, 1), mother, father, Family_tree.Gender.MALE);
        
        familyTree.add(me);
        familyTree.add(mother);
        
        me.getChildren();
        
        System.out.println(me);
        System.out.println(familyTree);
        // System.out.println(mother);
        return familyTree;
    }



    private static void save(FamilyTree tree, String filPath) {
        Writable Writable = new FileHandler();
        Writable.save(tree, filPath);
        


    }
}