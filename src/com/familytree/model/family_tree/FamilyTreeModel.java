
package com.familytree.model.family_tree;

import com.familytree.model.human.Human;
import com.familytree.model.io.Writeable;

import java.io.IOException;
import java.util.List;

public class FamilyTreeModel {
    private FamilyTree familyTree;
    private Writeable fileHandler;

    public FamilyTreeModel(Writeable fileHandler) {
        this.fileHandler = fileHandler;
        loadTree();
    }

    public void loadTree() {
        try {
            this.familyTree = fileHandler.readFromFile();
        } catch (IOException | ClassNotFoundException e) {
            this.familyTree = new FamilyTree();
        }
    }

    public void saveTree() {
        try {
            fileHandler.writeToFile(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Human> getNodes() {
        return familyTree.getNodes();
    }

    public void addNode(Human node) {
        familyTree.addNode(node);
        saveTree();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }
}
