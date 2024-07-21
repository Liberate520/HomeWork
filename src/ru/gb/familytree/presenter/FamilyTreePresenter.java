package ru.gb.familytree.presenter;

import ru.gb.familytree.model.FamilyTree;
import ru.gb.familytree.model.HumanInfo;
import ru.gb.familytree.view.FamilyTreeView;
import ru.gb.familytree.writer.FileHandler;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree<HumanInfo> familyTree;
    private FileHandler fileHandler;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public void addMember(HumanInfo member) {
        familyTree.addMember(member);
        view.showFamilyTree(familyTree.getMembers());
    }

    public void sortByName() {
        familyTree.sortByName();
        view.showFamilyTree(familyTree.getMembers());
    }

    public void sortByDob() {
        familyTree.sortByDob();
        view.showFamilyTree(familyTree.getMembers());
    }

    public void saveFamilyTree(String filePath) {
        try {
            fileHandler.save(familyTree.getMembers(), filePath);
            view.showSuccess("Family tree saved successfully.");
        } catch (IOException e) {
            view.showError("Failed to save family tree: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String filePath) {
        try {
            List<HumanInfo> loadedMembers = fileHandler.load(filePath);
            familyTree = new FamilyTree<>();
            for (HumanInfo member : loadedMembers) {
                familyTree.addMember(member);
            }
            view.showFamilyTree(familyTree.getMembers());
            view.showSuccess("Family tree loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            view.showError("Failed to load family tree: " + e.getMessage());
        }
    }

    public void findPersonByName(String name) {
        Optional<HumanInfo> person = familyTree.getMembers().stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .findFirst();

        if (person.isPresent()) {
            view.showFamilyTree(List.of(person.get()));
        } else {
            view.showError("Person not found: " + name);
        }
    }
}