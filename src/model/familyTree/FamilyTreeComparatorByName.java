package model.familyTree;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T human1, T human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
