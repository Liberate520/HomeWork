package OOP.SemDZ.homeWork;

import java.time.LocalDate;

import OOP.SemDZ.homeWork.view.View;
import OOP.SemDZ.homeWork.model.Service.Service;
import OOP.SemDZ.homeWork.model.familyTree.FamilyTree;
import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.model.human.Human;
import OOP.SemDZ.homeWork.model.write.FileHandler;
import OOP.SemDZ.homeWork.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        //Service service = new Service();
        //String filePath = "tree.txt";
        // FamilyTree tree =new FamilyTree<>();

        // Human human1 = new Human("Adam", Gender.Male, LocalDate.of(1975, 10, 21));
        // Human human2 = new Human("Eva", Gender.Female, LocalDate.of(1980,11,10));
        // Human human3 = new Human("Masha", Gender.Female, LocalDate.of(1998, 04, 15), human1, human2);
        // Human human4 = new Human("Andrey", Gender.Male, LocalDate.of(2000, 05, 18), human1, human2);

        View viev = new ConsoleUI();
        viev.start();

        // tree.addHuman(human1);
        // tree.addHuman(human2);
        // tree.addHuman(human3);
        // tree.addHuman(human4);
        // // human1.addChildren(human3);
        // // human2.addChildren(human3);
        // tree.wedding(human1, human2);

        // FileHandler file = new FileHandler();
        // file.save(tree, "C:\\Users\\korpa\\Documents\\Разработчик\\Java\\OOP\\SemDZ\\homeWork\\model\\write\\tree.data");

       

        // System.out.println(human3.getMather());
        // System.out.println(human3.getName());
        // System.out.println(human3.getId());
        // System.out.println(human1.getSpouse());
        // System.out.println(human1.toString());

        // System.out.println(tree.toString());
        // tree.sortByName();
        // System.out.println(tree.toString());
        // tree.sortByAge();
        // System.out.println(tree.toString());
       

        // System.out.println(human1.getSpouse().getName());

        //FileHandler file = new FileHandler();
        //file.save(service, filePath);
    }
}
