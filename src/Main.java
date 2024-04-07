
import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;
import java.time.Month;


public class Main {
    public static void main(String[] args) {
        String pathFile = "src/mytree.txt";
        String pathFile1 = "src/mytreeSTR.txt";
        //FamilyTree  myFamilyTree = read(pathFile);

        FamilyTree myFamilyTree = testTree();
        System.out.println(myFamilyTree);
        //save(myFamilyTree,pathFile);
        //saveString(myFamilyTree,pathFile1);
        myFamilyTree.sortByName();
        System.out.println(myFamilyTree);
        myFamilyTree.sortByAge();
        System.out.println(myFamilyTree);
    }



    static FamilyTree  read(String pathFile){
        FileHandler fileHandler = new FileHandler();
        return  (FamilyTree) fileHandler.read(pathFile);
    }

    static void save(FamilyTree familyTree, String pathFile){
        FileHandler fileHandler = new FileHandler();
           fileHandler.save(familyTree, pathFile);
   }
    static void saveString(FamilyTree familyTree, String pathFile){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree.getInfo(), pathFile);
    }

    static FamilyTree testTree() {
        FamilyTree myFamilyTree = new FamilyTree();
        Human human1 = new Human("Egor Konstantinov", Gender.Male, LocalDate.of(1964, Month.APRIL, 12));
        Human human2 = new Human("Karina Konstantinova", Gender.Female, LocalDate.of(1968, Month.DECEMBER, 12));
        myFamilyTree.addHuman(human1);
        myFamilyTree.addHuman(human2);
        Human human3 = new Human("Maria Petrova", Gender.Female, LocalDate.of(1991, Month.APRIL, 12),human2,human1);
        Human human4 = new Human("Semen Konstantinov", Gender.Male, LocalDate.of(1994, Month.DECEMBER, 16),human2,human1);
        myFamilyTree.addHuman(human3);
        myFamilyTree.addHuman(human4);
        Human human5 = new Human("Irina Petrova", Gender.Female, LocalDate.of(1971, Month.APRIL, 12));
        Human human6 = new Human("Ivan Konstantinov", Gender.Male, LocalDate.of(1974, Month.DECEMBER, 16));
        myFamilyTree.addHuman(human5);
        myFamilyTree.addHuman(human6);

        return myFamilyTree;
    }



}
