package model.service;

import model.Human.Gender;
import model.Human.Human;
import model.familyTree.FamilyTree;
import model.familyTree.ItemFamilyTree;

import java.time.LocalDate;

public class Service<E extends ItemFamilyTree> {
    private FamilyTree<E> familyTree;

    public Service(){
        familyTree =  new FamilyTree<E>();
    }

    public void addFamilyMember(String name, LocalDate dateOfBirth, Gender gender){
        Human human = new Human(name, dateOfBirth, gender);
        familyTree.addPerson((E) human);
    }

    public void sortByName(){familyTree.sortByName();}

    public void sortByAge(){familyTree.sortByAge();}

    public String getInfo(){
        return familyTree.toString();
    }

    public void printInfo(){
        System.out.println(familyTree.toString());
    }
}
