package model.service;


import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;

import java.time.LocalDate;
public class Service {
    private FamilyTree familyTree;
    public Service(FamilyTree familyTree){
        this.familyTree = familyTree;
    }
    public String getHumanListInfo(){
        return  familyTree.getAllInfo();
    }

    public void addHuman(String name, String lastName, LocalDate dateOfBirth, Gender gender) {

        familyTree.add(new Human(name, lastName, dateOfBirth, gender));
    }

    public void sortByName() {
        familyTree.sortByName();

    }
    public void sortByLastName() {
        familyTree.sortByLastName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

}
