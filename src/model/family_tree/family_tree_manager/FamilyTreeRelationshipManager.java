package model.family_tree.FamilyTreeManager;

import model.family_tree.TreeNode;

import java.io.Serializable;

public class FamilyTreeRelationshipManager<E extends TreeNode<E>> implements Serializable {
    public void addToParents(E node) {
        for (E parent : node.getParents()) {
            parent.addChild(node);
        }
    }

    public void addToChildren(E node) {
        for (E child : node.getChildren()) {
            child.addParent(node);
        }
    }

    public void updateRelationships(E node) {
        addToParents(node);
        addToChildren(node);
    }
}
