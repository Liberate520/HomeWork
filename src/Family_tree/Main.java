package Family_tree;

import java.time.LocalDate;

import Family_tree.Humans.Gender;
import Family_tree.Humans.Human;
import Family_tree.Tree.Family_tree;


public class Main {
    

    public static void main(String[] args){
        Service<Human> ser =new Service<>("Smith");      

        ser.addItem(new Human("Rikki", Gender.Male, LocalDate.of(2000,7,6)));
        ser.addItem(new Human("Dana", Gender.Female, LocalDate.of(2005,2,6)));
        ser.addItem(new Human("Suzy", Gender.Female, LocalDate.of(2024,1,6)));

        Family_tree<Human> tree = ser.getTree();

       
        System.out.println("__________________________________________________________________________________________________________");
        ser.SortByAge();
        System.out.println(tree.getlnfo());
        System.out.println("__________________________________________________________________________________________________________");
        ser.SortByID();
        System.out.println(tree.getlnfo());
        System.out.println("__________________________________________________________________________________________________________");
        ser.SortByName();
        System.out.println(tree.getlnfo());
        System.out.println("__________________________________________________________________________________________________________");
    }


}
