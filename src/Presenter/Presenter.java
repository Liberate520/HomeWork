package Presenter;

import Model.FamilyTree.FamilyTreeService.FamilyTreeService;
import Model.Human.Gender;
import View.ConsoleUI;

import java.time.LocalDate;

public class Presenter {
    FamilyTreeService familyTreeService;
    //ConsoleUI consoleUI;

    public Presenter() {
        familyTreeService = new FamilyTreeService();
//        this.consoleUI = consoleUI;
    }
    public void addToTree(String name, Gender gender, LocalDate dateOfBirth){
        familyTreeService.addToTree(name, gender, dateOfBirth);

    }

    public String getFamilyTreeInfo(){
        return familyTreeService.getFamilyTreeInfo();
    }

    public void sortByName() {
         familyTreeService.sortByName();
    }
}
