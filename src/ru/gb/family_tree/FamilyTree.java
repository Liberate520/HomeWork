package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long nodeIdCounter = 0;
    private List<Node> nodeList;

    public FamilyTree() {
        this.nodeList = new ArrayList<>();
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
}