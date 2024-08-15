package family_free;

import family_free.FamilyTree.FamilyTree;
import family_free.human.Gender;
import family_free.human.Human;
import family_free.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/family_free/writer/tree.txt";
    public static void main(String[] args) {
       // FamilyTree tree = completion();
       // Write_tree(tree);
        System.out.println(Read_tree());
    }

    private static FamilyTree completion(){
        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Sara", Gender.Female,LocalDate.of(2004,12,10));
        Human human2 = new Human("Mike",Gender.Male,LocalDate.of(2000,11,20));

        tree.addHuman(human1);
        tree.addHuman(human2);
        return tree;
    }

    private static void Write_tree(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(tree);

    }



    private static FamilyTree Read_tree(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.read();
        return(FamilyTree) fileHandler.read();
    }
}

