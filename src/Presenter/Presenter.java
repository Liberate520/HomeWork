package Presenter;

import Model.Human.Gender;
import Model.Service.HumanService;
import View.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    View view;
    HumanService humanService;

    public Presenter(View view) {
        this.view = view;
        humanService = new HumanService();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        String output = humanService.addHuman(name, gender, birthDate, deathDate);
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void addSpouse(int humanID, int spouseID){
        String output = humanService.addSpouse(humanID, spouseID);
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void deleteSpouse(int humanID){
        String output = humanService.deleteSpouse(humanID);
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void addParent(int humanID, int parentID){
        String output = humanService.addParent(humanID, parentID);
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void addChild(int humanID, int childID){
        String output = humanService.addChild(humanID, childID);
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void deleteHuman(int humanId) {
        String output = humanService.deleteHuman(humanId);
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void sortById() {
        String output = humanService.sortById();
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void sortByName() {
        String output = humanService.sortByName();
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void sortByAge() {
        String output = humanService.sortByAge();
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void sortByBirthdate() {
        String output = humanService.sortByBirthdate();
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void sortByChildrenNumber() {
        String output = humanService.sortByChildrenNum();
        view.printAnswer(output);
        showFamilyTreeInfo();
    }

    public void showFamilyTreeInfo() {
        String humanListInfo = humanService.getHumanListInfo();
        view.printAnswer(humanListInfo);
    }

    public void saveToFile(String filename) throws IOException {
        String output = humanService.saveToFile(filename);
        view.printAnswer(output);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        String output = humanService.loadFromFile(filename);
        view.printAnswer(output);
    }
}
