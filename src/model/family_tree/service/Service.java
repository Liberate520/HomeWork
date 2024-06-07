package model.family_tree.service;

import model.family_tree.tree.FamilyTree;
import model.family_tree.tree.TreeItem;
import model.family_tree.writer.Writable;

import java.io.IOException;

public class Service<T extends TreeItem<T>> {
    private FamilyTree<T> familyTree;
    private final Writable<T> writer;

    public Service(FamilyTree<T> familyTree, Writable<T> writer) {
        this.familyTree = familyTree;
        this.writer = writer;
    }

    public boolean addToTree(T obj) {
        return familyTree.addToTree(obj);
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

    public boolean setMother(T objForSet, T mother) {
        return familyTree.setMother(objForSet, mother);
    }

    public boolean setFather(T objForSet, T father){
        return familyTree.setFather(objForSet, father);
    }

    public int getNumInFamily() {
        return familyTree.getNumInFamily();
    }

    public T getFamilyMember(int index) {
        return familyTree.getFamilyMember(index);
    }

    public String ShowTree() {
        return familyTree.toString();
    }

    public void writeToFamilyTree(String path) throws IOException{
        writer.writeToFamilyTree(familyTree, path);
    }

    public void readFromFamilyTree(String path) throws IOException, ClassNotFoundException{
        familyTree = writer.readFromFamilyTree(path);
    }
}
