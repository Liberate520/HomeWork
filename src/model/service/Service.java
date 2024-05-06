package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writable.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public void addHuman(String name, LocalDate dateOfBirthday, Gender gender) {
        Human human = new Human(name, dateOfBirthday, gender);
//        familyTree = new FamilyTree<>();
        familyTree.add(human);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список дерева:\n");
        for (Human human : familyTree) {
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByID() {
        familyTree.sortByID();
    }

    public void loadTree() {
        this.familyTree = (FamilyTree<Human>) fileHandler.load();
    }

    public void saveTree() {
        fileHandler.save(familyTree);
    }

    public void addParent(String name, LocalDate dateOfBirthday, Gender gender, int id) {
        Human humanParent = new Human(name, dateOfBirthday, gender);
        familyTree.add(humanParent);
        Human child = searchByID(id);
        child.addParent(humanParent);
    }
    public void addChild(String name, LocalDate dateOfBirthday, Gender gender, int id) {
        Human humanChild = new Human(name, dateOfBirthday, gender);
        familyTree.add(humanChild);
        Human child = searchByID(id);
        child.addChild(humanChild);
    }

    public Human searchByID(int id) {
        return familyTree.search(id);
    }

    @Override
    public String toString() {
        return getFamilyTreeInfo();
    }



}
