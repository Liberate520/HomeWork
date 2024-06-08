package FamilyTree.model.service;

import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.human.Gender;
import FamilyTree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree = new FamilyTree<>();

    public void addElement(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        Human human = new Human(name, gender, birthDate, deathDate);
        familyTree.add(human);
    }

    public void setName(String name){
        familyTree.setName(name);
    }

    public void viewFamilyTree(){
        System.out.println(familyTree);
    }

    public void setWadding(long item1, long item2){
        familyTree.setWadding(item1, item2);
    }

}
