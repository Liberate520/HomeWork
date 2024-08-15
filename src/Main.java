import GB_FamilyTree.Family_Tree.Family_Tree.FamilyTree;
import GB_FamilyTree.Family_Tree.FileManager.FileHandler;
import GB_FamilyTree.Family_Tree.Human.Gender;
import GB_FamilyTree.Family_Tree.Human.Human;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    final static String filePath = "GB_FamilyTree/Family_Tree/FileManager/Tree.txt";
    public static void main(String[] args) {
        FamilyTree romanovFamilyTree = new FamilyTree();

        Human human1 = new Human("Иван", Gender.MALE, LocalDate.of(1985, 5, 14));
        Human human2 = new Human("Мария", Gender.FEMALE, LocalDate.of(1986, 8, 5));
        Human human3 = new Human("Павел", Gender.MALE, LocalDate.of(2015, 1, 2));

        romanovFamilyTree.addHuman(human1);
        romanovFamilyTree.addHuman(human2);
        romanovFamilyTree.addHuman(human3);

        romanovFamilyTree.addParentChildRelation(human1, human3);
        romanovFamilyTree.addParentChildRelation(human2, human3);

        romanovFamilyTree.printAllChildren(human1);
    }
}
