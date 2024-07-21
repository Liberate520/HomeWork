package Presenter;

import Model.FamilyTree.FamilyTreeService.FamilyTreeService;
import Model.Human.Gender;
import View.ConsoleUI;

import java.time.LocalDate;

public class Presenter {
    private static Presenter instance;
    FamilyTreeService familyTreeService;
//    ConsoleUI consoleUI;

    private Presenter() {
        this.familyTreeService = FamilyTreeService.getInstance();
//        this.consoleUI = consoleUI;
    }

    public static Presenter getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance of Presenter");
            instance = new Presenter();
        }
        return instance;
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
