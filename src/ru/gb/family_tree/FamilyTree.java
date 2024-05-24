package ru.gb.family_tree;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private long nodeIdCounter = 0;
    private List<Node> nodeList;
    private IOOperations ioOperations;

    public FamilyTree() {
        this.nodeList = new ArrayList<>();
        this.ioOperations = new FileIO();
    }

    public void addNode(Node node) {
        if (node != null && !nodeList.contains(node)) {
            nodeList.add(node);
            node.setId(nodeIdCounter++);
        }
    }

    public List<Node> getAllNodes() {
        return nodeList;
    }

    public void saveTreeToFile(String filename) throws IOException {
        ioOperations.saveTree(nodeList, filename);
    }

    public void loadTreeFromFile(String filename) throws IOException, ClassNotFoundException {
        this.nodeList = ioOperations.loadTree(filename);
        this.nodeIdCounter = nodeList.size(); // обновить счетчик
    }

    public void printTree() {
        for (Node node : nodeList) {
            System.out.println(node.getInfo());
        }
    }
}