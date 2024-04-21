package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.model.human.Human;
import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Presenter {
    private View view;
    private Service service;
    private FamilyTree<Human> familyTree;
    private static final String filePath = "src/family_tree/model/writer/family.txt";

    public Presenter(View view) {
        this.view = view;
        this.service = new Service(familyTree);
    }

    public void initialize() {
        loadFamilyTree();
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

    public boolean saveFamilyTree() {
        return service.saveFamilyTreeToFile(filePath);
    }
    
    public void loadFamilyTree() {
        FamilyTree<Human> loadedTree = service.readFamilyTreeFromFile(filePath);
        if (loadedTree != null) {
            System.out.println("Дерево успешно загружено.");
            setFamilyTree(loadedTree);
        } else {
            System.out.println("Не удалось загрузить дерево из файла.");
        }
    }

    public void setFamilyTree(FamilyTree<Human> newTree) {
        this.familyTree = newTree;
        service.setFamilyTree(newTree); 
        updateFamilyTreeView(); 
    }
    
    private void updateFamilyTreeView() {
        if (view != null && familyTree != null) {
            view.displayFamilyTree();
        }
    }

    public Human findHumanByName(String name) {
        return service.findHumanByName(name);
    }

    public void createRelationships(String husbandName, String wifeName, List<String> childrenNames) {
        Human husband = findHumanByName(husbandName);
        Human wife = findHumanByName(wifeName);
        List<Human> children = childrenNames.stream()
                                            .map(this::findHumanByName)
                                            .collect(Collectors.toList());
        service.createRelationships(husband, wife, children.toArray(new Human[0]));
        updateHumanListInfo();
    }

    private void updateHumanListInfo() {
        String humanListInfo = service.getFamilyTreeInfo();
        view.printAnswer(humanListInfo);
    }

    public FamilyTree<Human> getFamilyTree() {
        return service.getFamilyTree();
    }

    public boolean doesHumanExist(String name) {
        return findHumanByName(name) != null;
    }

}