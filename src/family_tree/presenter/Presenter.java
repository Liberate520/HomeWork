package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.model.writer.Writable;
import family_tree.model.human.Human;
import family_tree.model.human.Gender;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Writable<?> fileHandler) {
        this.view = view;
        this.service = new Service(fileHandler);
        loadFamilyTree();
    }

    public void loadFamilyTree() {
        service.readFamilyTreeFromFile();
        view.displayFamilyTree(service.getFamilyTreeInfo());
    }

    public boolean saveFamilyTree() {
        return service.saveFamilyTreeToFile(); 
    }

    public String getFamilyTreeInfo() {
        return service.getFamilyTreeInfo();
    }

    public void createAndAddHuman(String name, Gender gender, LocalDate dob) {
        service.createAndAddHuman(name, gender, dob);
        getHumanListInfo();
    }

    public void createAndAddHumanWithParents(String name, Gender gender, LocalDate dob, Human mother, Human father) {
        service.createAndAddHuman(name, gender, dob, mother, father);
        getHumanListInfo();
    }

    public void setWedding(Human partner1, Human partner2) {
        service.setWedding(partner1, partner2);
        getHumanListInfo();
    }

    public void setDivorce(Human partner1, Human partner2) {
        service.setDivorce(partner1, partner2);
        getHumanListInfo();
    }

    public void addChildToParents(Human child, Human mother, Human father) {
        service.addChildToParents(child, mother, father);
        getHumanListInfo();
    }

    public void addParentToChild(Human parent, Human child) {
        service.addParentToChild(parent, child);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String humanListInfo = service.getFamilyTreeInfo();
        view.printAnswer(humanListInfo);
    }    

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public Human findHumanByName(String name) {
        return service.findHumanByName(name);
    }

    public void createRelationships(String husbandName, String wifeName, List<String> childrenNames) {
        service.createRelationships(husbandName, wifeName, childrenNames);
        getHumanListInfo();
    }

    public boolean doesHumanExist(String name) {
        return findHumanByName(name) != null;
    }

}