import family_tree.FamilyTree;
import family_tree.Service;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/writer/tree.txt";

    public static void main(String[] args) {
//        FamilyTree tree = load();
        Service <Human>  myFamilyTree= new Service<>();
        myFamilyTree.addHuman("Leha",Gender.Male, LocalDate.of(1999,9,9));
        myFamilyTree.addHuman("Oleg", Gender.Male, LocalDate.of(1995,7,2));
        myFamilyTree.addHuman("Nastya", Gender.Female, LocalDate.of(2001,3,16));
        myFamilyTree.addHuman("Nadezhda", Gender.Female, LocalDate.of(1974,6,26));
        myFamilyTree.setWedding("Oleg", "Nastya");
        myFamilyTree.addHuman("Andrey", Gender.Male, LocalDate.of(1970,7,25));
        myFamilyTree.setWedding("Nadezhda", "Andrey");
        myFamilyTree.addHuman("Katya", Gender.Female, LocalDate.of(2004,12,24));
        myFamilyTree.addParent("Katya","Andrey");
        myFamilyTree.addParent("Katya","Nadezhda");
        myFamilyTree.addParent("Oleg","Andrey");
        myFamilyTree.addParent("Oleg","Nadezhda");
        myFamilyTree.addChild("Nadezhda","Oleg");
        myFamilyTree.addChild("Nadezhda","Katya");
//        myFamilyTree.sortByName();
//        myFamilyTree.sortByAge();
        myFamilyTree.sortByBirthDate();
        save(myFamilyTree.getFamilyTree());
        System.out.println(myFamilyTree.getFamilyTree());
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree<Human> familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

}
