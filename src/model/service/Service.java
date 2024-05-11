package model.service;

import model.family_tree.FamilyTree;
import model.human.Element;
import model.human.Gender;
import model.human.Human;
import model.writable.FileHandler;
import model.writable.Readable;
import model.writable.Writable;

import java.time.LocalDate;

public class Service<E extends Element<E>> {
    private FamilyTree<E> familyTree;
    private Writable writableHandler;
    private Readable readableHandler;

    public Service() {
        this.familyTree = new FamilyTree();
    }

    public int addHuman(String name, LocalDate dateOfBirthday, Gender gender) {
        Element<E> human = new Human(name, dateOfBirthday, gender);
        return familyTree.add((E) human);
    }

    public String getFamilyTreeInfo() {
        return familyTree.toString();
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

    public void loadTreeSerialize() {
        this.readableHandler = new FileHandler();
        this.familyTree = (FamilyTree<E>) readableHandler.load();
    }

    public void saveTreeSerialize() {
        this.writableHandler = new FileHandler();
        writableHandler.save(familyTree);
    }

    public void addParent(int child, int parent) {
        familyTree.addParent(child, parent);
    }

    public void addChild(int child, int parent) {
        familyTree.addChild(child, parent);
    }

    public boolean availability(int id) {
        return familyTree.availability(id);
    }

    @Override
    public String toString() {
        return getFamilyTreeInfo();
    }
}
