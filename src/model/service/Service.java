package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writable.FileHandler;
import view.ConsoleUI;

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

    public void addParent(ConsoleUI human) {
        //todo метод добавления родителя
        human.addParent();
    }

    @Override
    public String toString() {
        return getFamilyTreeInfo();
    }


}
