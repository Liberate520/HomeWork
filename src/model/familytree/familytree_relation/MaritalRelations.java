package model.familytree.familytree_relation;

import model.familytree.TreeNodes;

import java.io.Serializable;

public class MaritalRelations<T extends TreeNodes<T>> implements Serializable {

    public boolean setMarried(T node1 , T node2) {
        if (node1.getSpouse() == null && node2.getSpouse() == null) {
            node1.setSpouse(node2);
            node2.setSpouse(node1);
            return true;
        }
        return false;
    }

    public boolean setDivorced(T node1 , T node2) {
        if (node1.getSpouse() != null && node2.getSpouse() != null) {
            node1.setSpouse(null);
            node2.setSpouse(null);
            return true;
        }
        return false;
    }
}
