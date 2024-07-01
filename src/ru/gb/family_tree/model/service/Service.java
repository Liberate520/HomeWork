package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree.FileHandler;
import ru.gb.family_tree.model.tree.Writeable;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTreeList;
    private FileHandler fileHandler;

    public Service() {
        familyTreeList = new FamilyTree<>();
        fileHandler = new FileHandler();
    }


    public Human createElement(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender) {
        Human element = new Human(firstName, lastName, dob, dod, gender);
        return element;
    }

    public Human createElement(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother) {
        Human element = new Human(firstName, lastName, dob, dod, gender, father, mother);
        return element;
    }

    public Human createElement(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, Human... children) {
        Human element = new Human(firstName, lastName, dob, dod, gender, father, mother, children);
        return element;
    }


    public void addHumansInFamTree(Human... humans) {
        familyTreeList.addHumansInFamTree(humans);
    }

    public void removeHumansFromFamTree(Human... humans) {
        familyTreeList.removeHumansFromFamTree(humans);
    }

    public Human findHuman(String firstName) {
        return familyTreeList.findHuman(firstName);
    }


    public void sortByFirstName() {
        familyTreeList.sortByFirstName();
    }

    public void sortById() {
        familyTreeList.sortById();
    }

    public void sortByGender() {
        familyTreeList.sortByGender();
    }

    public void sortByDob() {
        familyTreeList.sortByDob();
    }

    public void sortByDod() {
        familyTreeList.sortByDod();
    }


    public FamilyTree<Human> ShowTree() {
        return familyTreeList;
    }
    public boolean treeIsEmpty(){
        return familyTreeList.treeIsEmpty();    }


    public FamilyTree load(String filePath) {
        Writeable writeable = fileHandler;
        return (FamilyTree) writeable.read(filePath);
    }


    public void save(FamilyTree familyTree, String filePath) {
        Writeable writeable = fileHandler;
        writeable.save(familyTree, filePath);
    }

    public void updateTree(FamilyTree newTree) {
        this.familyTreeList = newTree;
    }
}
