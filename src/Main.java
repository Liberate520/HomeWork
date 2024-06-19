
import FamilyTree.FamilyTree;
import FileHandler_and_Writable.FileHandler;
import Gender.Gender;
import Human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = read("/Users/ksyul/Desktop/homeWork/src/familytree.txt");
        System.out.println(familyTree);

        familyTree.sortByName();
        System.out.println(familyTree);

        familyTree.sortByAge();
        System.out.println(familyTree);

//        Human sergey = new Human("Sergey", null, null, Gender.Male, LocalDate.of(1981, 7, 17), null);
//        System.out.println(sergey.getAge());
//        System.out.println(sergey);
//
//        Human maria = new Human("Maria", null, null, Gender.Female, LocalDate.of(1981, 9, 1), null);
//        Human ksenia = new Human("Ksenia", null, null, Gender.Female, LocalDate.of(2007, 9,1), null);
//        Human julia = new Human("Julia", sergey, maria, Gender.Female, LocalDate.of(2010, 7, 18), null);
//
//        sergey.addChild(ksenia);
//        sergey.addChild(julia);
//        maria.addChild(ksenia);
//        maria.addChild(julia);
//        System.out.println(sergey.getChildren());
//
//        ksenia.addParent(maria);
//        ksenia.addParent(sergey);
//        System.out.println(ksenia.getParents());
//        System.out.println(ksenia.getSistersAndBrothers());
//
//        Human nadya = new Human("Nadya", null, null, Gender.Female, LocalDate.of(1950, 2,5), null);
//        sergey.addParent(nadya);
//        System.out.println(nadya.getBirthDate());
//        System.out.println(nadya.getGender());
//
//        FamilyTree<Human> familyTree = new FamilyTree<Human>();
//        familyTree.addFamilyItem(sergey);
//        familyTree.addFamilyItem(maria);
//        familyTree.addFamilyItem(ksenia);
//        familyTree.addFamilyItem(julia);
//        familyTree.addFamilyItem(nadya);
//
//        Human nadejda = new Human("Nadya", null, null, Gender.Female, LocalDate.of(2012, 12,12), null);
//        familyTree.addFamilyItem(nadejda);
//        System.out.println( familyTree.findFamilyItemByName("Nadya") );
//
//        System.out.println(familyTree);
//
//
//        save(familyTree, "/Users/ksyul/Desktop/homeWork/src/familytree.txt");

    }

    static void save(FamilyTree familyTree , String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    static FamilyTree read(String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }


}