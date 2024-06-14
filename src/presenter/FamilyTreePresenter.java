package presenter;

import model.FamilyTree;
import model.Person;
import storage.DataStorage;
import view.TreeView;

import java.io.IOException;
import java.util.List;

public class FamilyTreePresenter implements TreePresenter {
    private FamilyTree<Person> familyTree;
    private TreeView view;
    private DataStorage storage;

    public FamilyTreePresenter(TreeView view, DataStorage storage) {
        this.view = view;
        this.storage = storage;
        this.familyTree = new FamilyTree<>();
    }

    @Override
    public void loadFamilyTree() {
        try {
            List<Person> loadedMembers = storage.loadFromFile("family_tree.dat");
            familyTree.setMembers(loadedMembers);
            view.displayMembers(loadedMembers);
        } catch (IOException e) {
            view.showMessage("Error loading family tree: " + e.getMessage());
        }
    }

    @Override
    public void addMember(String name, int age) {
        Person person = new Person(name, age);
        familyTree.addMember(person);
        view.showMessage("Member added: " + person);
        saveFamilyTree();
    }

    @Override
    public void findMember(String name) {
        Person person = familyTree.findPersonByName(name);
        if (person != null) {
            view.showMessage("Found: " + person);
        } else {
            view.showMessage("Person not found.");
        }
    }

    @Override
    public void getChildrenOf(String name) {
        Person parent = familyTree.findPersonByName(name);
        if (parent != null) {
            List<Person> children = familyTree.getChildrenOf(parent);
            view.displayChildren(children);
        } else {
            view.showMessage("Person not found.");
        }
    }

    private void saveFamilyTree() {
        try {
            storage.saveToFile("family_tree.dat", familyTree.getMembers());
        } catch (IOException e) {
            view.showMessage("Error saving family tree: " + e.getMessage());
        }
    }
}
