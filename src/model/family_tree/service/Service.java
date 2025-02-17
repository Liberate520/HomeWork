package model.family_tree.service;

import model.family_tree.instances.Gender;
import model.family_tree.instances.Human;
import model.family_tree.tree.FamilyTree;
import model.family_tree.tree.TreeItem;
import model.family_tree.writer.Writable;

import java.io.IOException;
import java.util.Date;

public class Service {
    private FamilyTree<Human> familyTree;
    private final Writable<Human> writer;

    public Service(FamilyTree<Human> familyTree, Writable<Human> writer) {
        this.familyTree = familyTree;
        this.writer = writer;
    }

    public boolean addToTree(Human obj) {
        return familyTree.addToTree(obj);
    }

    public boolean addToTree(String name, Date date, Gender gender){
        Human human = new Human(name, date, gender);
        return addToTree(human);
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByDeathDate() {
        familyTree.sortByDeathDate();
    }

    public boolean setMother(Human objForSet, Human mother) {
        return familyTree.setMother(objForSet, mother);
    }

    public boolean setFather(Human objForSet, Human father){
        return familyTree.setFather(objForSet, father);
    }

    public int getNumInFamily() {
        return familyTree.getNumInFamily();
    }

    public Human getFamilyMember(int index) {
        return familyTree.getFamilyMember(index);
    }

    public String ShowTree() {
        return familyTree.toString();
    }

    public void writeToFamilyTree() throws IOException{
        writer.writeToFamilyTree(familyTree);
    }

    public void readFromFamilyTree() throws IOException, ClassNotFoundException{
        familyTree = writer.readFromFamilyTree();
    }
}
