package model.service;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;
import view.commands.CommandList;

import java.util.List;

public class Service<E extends FamilyTreeItem> implements CommandList<E> {
    private int id;
    private FamilyTree<E> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void add(E item) {
        item.setId(id++);
        familyTree.add(item);
    }

    public List<E> getFamilyTree() {
        return familyTree.getFamilyTree();
    }

    public void setFamilyTree(List<E> familyTree) {
        this.familyTree.setFamilyTree(familyTree);
    }

    public List<E> findByName(String name) {
        return familyTree.findByName(name);
    }

    public E findById(int id) {
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

    public String printList(List<E> list) {
        return familyTree.printList(list);
    }

}
