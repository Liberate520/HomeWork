package Presenter;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.FamilyTreeService.FamilyTreeService;
import Model.Human.Gender;
import Model.Writer.FileHandler;
import View.ConsoleUI;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private static Presenter instance;
    FamilyTreeService familyTreeService;
    FileHandler fileHandler;
//    ConsoleUI consoleUI;

    private Presenter() {
        this.familyTreeService = FamilyTreeService.getInstance();
        this.fileHandler = FileHandler.getInstance();
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

    public boolean savetoFile() throws IOException {
        fileHandler.writeObjecttoFile(familyTreeService.getFamilyTree());
        return true;
    }

    public Object RestoreTreeFromFile() throws IOException, ClassNotFoundException {
        return fileHandler.readObjectfromFile();
    }

    public boolean addSpouseToFamilyMember(Integer idMember, Integer idSpouse){
        familyTreeService.addSpouseToFamilyMember(idMember, idSpouse);
        return true;
    }
}
