package model.family_tree.FamilyTreeManager;

import model.family_tree.TreeNode;

import java.io.Serializable;

public class FamilyTreeSpouseManager<E extends TreeNode<E>> implements Serializable {
    public boolean setWedding(E node1, E node2) {
        if (node1.getSpouse() == null && node2.getSpouse() == null) {
            node1.setSpouse(node2);
            node2.setSpouse(node1);
            return true;
        }
        return false;
    }

    public boolean setDivorce(E node1, E node2) {
        if (node1.getSpouse() != null && node2.getSpouse() != null) {
            node1.setSpouse(null);
            node2.setSpouse(null);
            return true;
        }
        return false;
    }
}
