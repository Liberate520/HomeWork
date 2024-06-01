package Family_tree;

import java.time.LocalDate;

import Family_tree.Humans.Gender;
import Family_tree.Humans.Human;
import Family_tree.Tree.Family_tree;


public class Main {
    

    public static void main(String[] args){
        Family_tree<Human> tree = new Family_tree<>("Smith");
        Human Di = new Human("Di", Gender.Female, LocalDate.of(2005, 5,1));
        Human Peter = new Human("Peter", Gender.Male, LocalDate.of(2003, 12, 12));
        tree.add(Peter);
        tree.add(Di);
        System.out.println(tree.search(0));
        System.out.println(tree.getlnfo());
        
    }


}
