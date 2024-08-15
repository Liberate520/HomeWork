package family_free;

import family_free.FamilyTree.FamilyTree;
import family_free.human.Gender;
import family_free.human.Human;
import family_free.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/family_free/writer/tree.txt";
    public static void main(String[] args) {
        FamilyTree tree = testTree();
     //   FamilyTree tree = load();

        save(tree);
        System.out.println(tree);
    }

    private static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static FamilyTree save(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static FamilyTree testTree(){
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Sara", Gender.Female,LocalDate.of(2004,12,10));
        Human human2 = new Human("Mike",Gender.Male,LocalDate.of(2000,11,20));
        Human human3 = new Human("Mike", Gender.Male,LocalDate.of(1999,9,23));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);

        human1.addChild(human2);
        human1.addChild(human3);
        return familyTree;
    }
}

