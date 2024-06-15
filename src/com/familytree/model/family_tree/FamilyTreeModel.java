

package com.familytree.model.family_tree;

import com.familytree.model.human.Human;
import com.familytree.model.io.FileHandler;
import com.familytree.model.io.Writeable;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeModel<T extends TreeNode> {
    private FamilyTree<T> familyTree;
    private Writeable fileHandler;
    private String filePath;

    public FamilyTreeModel(String filePath) {
        this.filePath = filePath;
        this.fileHandler = new FileHandler();
        loadTree();
    }

    public void loadTree() {
        try {
            this.familyTree = (FamilyTree<T>) fileHandler.readFromFile(filePath);
        } catch (IOException | ClassNotFoundException e) {
            this.familyTree = new FamilyTree<>();
        }
    }

    public void saveTree() {
        try {
            fileHandler.writeToFile((FamilyTree<Human>) familyTree, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> getNodes() {
        return familyTree.getNodes();
    }

    public void addNode(T node) {
        familyTree.addNode(node);
        saveTree();
    }

    public void sortByName() {
        List<T> nodes = getNodes();
        nodes.sort(Comparator.comparing(TreeNode::getName));
        saveTree(); // Сохраняем отсортированный список
    }

    public void sortByBirthDate() {
        List<T> nodes = getNodes();
        nodes.sort(Comparator.comparing(TreeNode::getBirthDate));
        saveTree(); // Сохраняем отсортированный список
    }
}
