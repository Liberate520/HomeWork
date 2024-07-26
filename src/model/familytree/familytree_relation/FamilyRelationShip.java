package model.familytree.familytree_relation;

import model.familytree.TreeNodes;

import java.io.Serializable;
import java.util.List;

public class FamilyRelationShip <T extends TreeNodes<T>> implements Serializable {

    public void addToParent(T node) {
        for (T parent : node.getParents()) {
            parent.addChild(node);
        }
    }

    public void addToChild(T node) {
        for (T child : node.getChildren()) {
            child.addParent(node);
        }
    }

    public void updateRelation(T node) {
        addToParent(node);
        addToChild(node);
    }
}
