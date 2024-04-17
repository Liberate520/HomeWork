package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.model.human.Human;
import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, FamilyTree<Human> tree) {
        this.view = view;
        this.service = new Service(tree);
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
        String humanListInfo = service.getFamilyTree().getInfo();
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

    public boolean saveFamilyTreeToFile(String filePath) {
        return service.saveFamilyTreeToFile(filePath);
    }
    
    public FamilyTree<Human> readFamilyTreeFromFile(String filePath) {
        return service.readFamilyTreeFromFile(filePath);
    }
    
    public void setFamilyTree(FamilyTree<Human> tree) {
        this.service.setFamilyTree(tree);
    }

    public void createRelationships(Human husband, Human wife, Human... children) {
        service.createRelationships(husband, wife, children);
        getHumanListInfo();
    }

    public FamilyTree<Human> getFamilyTree() {
        return service.getFamilyTree();
    }

}