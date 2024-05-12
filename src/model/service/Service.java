package model.service;

import model.family_tree.Tree;
import model.human.Gender;
import model.human.Human;
import model.writable.Readable;
import model.writable.Writable;

import java.time.LocalDate;

public class Service {
    private Tree familyTree;

    public Service(Tree familyTree) {
        this.familyTree = familyTree;
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

    public void loadTree(Readable readable) {
        this.familyTree = (Tree) readable.load();
    }

    public void saveTree(Writable writable) {
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
