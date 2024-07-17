package model.family_tree.FamilyTreeManager;

import model.family_tree.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SiblingsManager<E extends TreeNode<E>> implements Serializable {
    public List<E> getSiblings(E node) {
        if (node == null) {
            return null;
        }
        List<E> siblings = new ArrayList<>();
        for (E parent : node.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(node)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }
}
