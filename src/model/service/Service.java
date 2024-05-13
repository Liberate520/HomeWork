package model.service;

import model.family_tree.Tree;
import model.human.Gender;
import model.human.Human;
import model.writable.Readable;
import model.writable.Writable;

import java.time.LocalDate;

public class Service {
    private Tree familyTree;
    private Readable readable;
    private Writable writable;

    public Service(Tree familyTree, Readable readable, Writable writable) {
        this.familyTree = familyTree;
        this.readable = readable;
        this.writable = writable;
    }

    public int addHuman(String name, LocalDate dateOfBirthday, Gender gender) {
        Human human = new Human(name, dateOfBirthday, gender);
        return familyTree.add(human);
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

    public void loadTree() {
        this.familyTree = (Tree) readable.load();
    }

    public void saveTree() {
        writable.save(familyTree);
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
