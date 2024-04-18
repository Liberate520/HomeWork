package Family_Tree;

import Family_Tree.familytree.FamilyTree;
import Family_Tree.human.Gender;
import Family_Tree.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = testTree();
        System.out.print(tree);
        /*String filepath = "Family_Tree/FileHandler/tree.txt";*/
        save(tree, filepath); //Ошибка

    }
    static FamilyTree read(String filepath) throws IOException {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filepath);//Метод read не работает
    }
    static void save(FamilyTree familyTree, String filepath) throws IOException {
        FileHandler fileHandler = new FileHandler();
        FileHandler.save(familyTree, filepath);
    }
    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();
        Human Ivan = new Human("Иван", Gender.Male, LocalDate.of(1978, 9, 4));
        tree.add(Ivan);
        /*writeTo(Ivan);*/
        return tree;
    }
}