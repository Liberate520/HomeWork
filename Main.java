package OOP.SemDZ.homeWork;

import java.time.LocalDate;

import OOP.SemDZ.homeWork.familyTree.FamilyTree;
import OOP.SemDZ.homeWork.human.Gender;
import OOP.SemDZ.homeWork.human.Human;
import OOP.SemDZ.homeWork.write.FileHandler;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();
        String filePath = "tree.txt";

        Human human1 = new Human("Adam", Gender.Male, LocalDate.of(1975, 10, 21));
        Human human2 = new Human("Eva", Gender.Female, LocalDate.of(1980,11,10));
        Human human3 = new Human("Masha", Gender.Female, LocalDate.of(1998, 04, 15), human1, human2);
        Human human4 = new Human("Andrey", Gender.Male, LocalDate.of(2000, 05, 18), human1, human2);

        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);
        //human1.addChildren(human3);
        //human2.setChildren(human3);
        tree.wedding(human1, human2);

        // System.out.println(human3.getMather());
        // System.out.println(human3.getName());
        // System.out.println(human3.getId());
        // System.out.println(human1.getSpouse());
        // System.out.println(human1.toString());
        System.out.println(tree.toString());
        tree.sortByName();
        System.out.println(tree.toString());
        tree.sortByAge();
        System.out.println(tree.toString());

        

        System.out.println(human1.getSpouse().getName());

        FileHandler file = new FileHandler();
        file.save(tree, filePath);
    }
}
