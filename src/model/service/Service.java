package model.service;

import model.family_tree.FamilyTree;
import model.human.Human;
import model.human.Sex;
import model.writer.MyWriter;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree<Human> familyTree;
    MyWriter<Human> handler;

    public Service(MyWriter handler) {
        familyTree = new FamilyTree<>();
        this.handler = handler;
    }

    public void add(String name, LocalDate birthDate, LocalDate deathDate, Sex sex, Human father, Human mother) {
        Human human = new Human(name, birthDate, deathDate, sex, father, mother);
        human.setId(id++);
        familyTree.add(human);
    }

    public List<Human> getFamilyTree() {
        return familyTree.getFamilyTree();
    }

    public void setFamilyTree(List<Human> familyTree) {
        this.familyTree.setFamilyTree(familyTree);
    }

    public List<Human> findByName(String name) {
        return familyTree.findByName(name);
    }

    public Human findById(int id) {
        return familyTree.findById(id);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void setBirthDate(Human human, LocalDate birthDate) {
        human.setBirthDate(birthDate);
    }

    public void setDeathDate(Human human, LocalDate deathDate) {
        human.setDeathDate(deathDate);
    }

    public void setParents(Human human, Human father, Human mother) {
        human.setFamilyTies(father, mother);
    }

    public String printList(List<Human> list) {
        return familyTree.printList(list);
    }

    public boolean save() {
        return handler.save(familyTree);
    }

    public boolean load() {
        FamilyTree<Human> loadedTree = handler.load();
        if (loadedTree != null) {
            familyTree = loadedTree;
            return true;
        } else {
            return false;
        }
    }
}
