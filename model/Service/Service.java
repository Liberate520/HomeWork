package OOP.SemDZ.homeWork.model.Service;

import java.time.LocalDate;

import OOP.SemDZ.homeWork.model.familyTree.FamilyTree;
import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.model.human.Human;

public class Service {
    FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }
    
    public void addHuman (String name, Gender gender, LocalDate birthDate){
        Human human = new Human(name, gender, birthDate);
        tree.addHuman(human); 
    }

    public void addHuman(Human human) {
        tree.addHuman(human);
    }

    public String printFamilyTree(){
        return tree.toString();
    }

    public void wedding (Human groom, Human bride){
        groom.setSpouse(bride);
        bride.setSpouse(groom);
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    
}
