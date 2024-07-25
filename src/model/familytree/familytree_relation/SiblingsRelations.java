package model.familytree.familytree_relation;

import model.familytree.TreeNodes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SiblingsRelations<T extends TreeNodes<T>> implements Serializable {

    public List<T> getSiblings(T node) {
       if (node == null) {
           return null;
       }
       List<T> siblings = new ArrayList<>();
       for (T parent : node.getParents()) {
           for (T child : parent.getChildren()) {
               if (child != node) {
                   siblings.add(child);
               }
           }
       }
       return siblings;
    }
}
