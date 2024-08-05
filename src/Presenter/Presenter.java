package Presenter;

import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Service.HumanService;
import View.ConsoleUI;
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
        humanService.addHuman(name, gender, birthDate, deathDate);
        System.out.println(name + " добавлен в семейное дерево");
        showFamilyTreeInfo();
    }

    public void addSpouse(int humanID, int spouseID){
        humanService.addSpouse(humanID, spouseID);
        showFamilyTreeInfo();
    }

    public void deleteSpouse(int humanID){
        humanService.deleteSpouse(humanID);
        showFamilyTreeInfo();
    }

    public void addParent(int humanID, int parentID){
        humanService.addParent(humanID, parentID);
        showFamilyTreeInfo();
    }

    public void addChild(int humanID, int childID){
        humanService.addChild(humanID, childID);
        showFamilyTreeInfo();
    }

    public void deleteHuman(int humanId) {
        humanService.deleteHuman(humanId);
        System.out.println("Человек с ID" + humanId + " удален из семейного дерева");
        showFamilyTreeInfo();
    }

    public void sortByName() {
        humanService.sortByName();
        showFamilyTreeInfo();
    }

    public void sortByAge() {
        humanService.sortByAge();
        showFamilyTreeInfo();
    }

    public void sortByBirthdate() {
        humanService.sortByBirthdate();
        showFamilyTreeInfo();
    }

    public void sortByChildrenNumber() {
        humanService.sortByChildrenNum();
        showFamilyTreeInfo();
    }

    public void showFamilyTreeInfo() {
        String humanListInfo = humanService.getHumanListInfo();
        view.printAnswer(humanListInfo);
    }

    public void saveToFile(String filename) throws IOException {
        humanService.saveToFile(filename);
        System.out.println("Семейное дерево сохранено в файл " + filename);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        humanService.loadFromFile(filename);
        System.out.println("Семейное дерево загружено из файла " + filename);
    }
}
