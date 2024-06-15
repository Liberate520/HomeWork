package Model.FamilyTree;

import Model.Human.Human;

import java.io.Serializable;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>, Serializable {
    List<T> getFamilyTree();
    void addCreatureToFamilyTree();
    int getAge();
    String getName();
    List<T> getChildren();
    String getInfo();
}
