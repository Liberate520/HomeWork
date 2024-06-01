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
        Di.setSpouse(Peter);
        Peter.setSpouse(Di);  
        Human Bobbi = new Human("Bobby", Gender.Male, LocalDate.of(2024,3,8));
        Di.addChild(Bobbi);
        Peter.addChild(Bobbi);
        Bobbi.setFather(Peter);
        Bobbi.setMother(Di);  
        tree.add(Bobbi);    
        System.out.println(tree.getlnfo());
        System.out.println("___________________________________________________________________");
        Human x = tree.search(2);
        System.out.println(x.getlnfo());
        
    }


}
