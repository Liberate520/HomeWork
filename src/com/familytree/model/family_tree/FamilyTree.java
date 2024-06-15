

package com.familytree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends TreeNode> implements Serializable {
    private List<T> nodes;

    public FamilyTree() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(T node) {
        nodes.add(node);
    }

    public List<T> getNodes() {
        return nodes;
    }
}
