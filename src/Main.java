import FamilyTree.FamilyTree;
import Human.*;
import writer.FileHandler;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/writer/tree.txt";

//        FamilyTree.FamilyTree tree = read(filePath);
        FamilyTree tree = newTree();
        System.out.println(tree);

        tree.sortByName();
        System.out.println(tree);

        tree.sortByBirthDate();
        System.out.println(tree);

//        save(tree, filePath);
    }

    static FamilyTree read(String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    static void save(FamilyTree familyTree, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    static FamilyTree newTree(){
        FamilyTree tree = new FamilyTree();
        Human ilya = new Human("Илья", "Шевченко", Gender.Male, LocalDate.of(1984,3,3));
        Human anna = new Human("Анна", "Степанова", Gender.Female, LocalDate.of(1990,9,19));
        tree.add((Methods) ilya);
        tree.add((Methods) anna);
        Human maria = new Human("Мария", "Шевченко", Gender.Female, LocalDate.of(2012, 9, 17));
        Human varvara = new Human("Варвара", "Шевченко", Gender.Female, LocalDate.of(2019, 10, 27));
        tree.add((Methods) maria);
        tree.add((Methods) varvara);
        anna.addChild(maria);
        anna.addChild(varvara);
        ilya.addChild(maria);
        ilya.addChild(varvara);
        maria.addParent(anna);
        maria.addParent(ilya);

        return tree;
    }

}
