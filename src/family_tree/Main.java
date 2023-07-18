package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.E;
import family_tree.writer.FileHandler;
import family_tree.family_tree.FamilyTreeItem;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        String filePath = "src/family_tree/tree.out";
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = testTree();
//        System.out.println(tree);
//        fileHandler.save(tree, filePath);

        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        System.out.println(tree);



    }

    static FamilyTree testTree(){



        FamilyTree tree = new FamilyTree();
        E vasya = new E("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        E masha = new E("Мария", Gender.Female, LocalDate.of(1965, 9, 15));


        tree.add((FamilyTreeItem) new E("Кристина",
                Gender.Female,
                LocalDate.of(1988, 7, 5),
                (E) tree.getByName("Василий"),
                (E) tree.getByName("Мария")));
        tree.add((FamilyTreeItem) new E("Семен",
                Gender.Male,
                LocalDate.of(1991, 1, 25),
                (E) tree.getByName("Василий"),
                (E) tree.getByName("Мария")));


        return tree;
    }

}
