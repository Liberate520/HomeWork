package Family.pack.Human.comparators;

import Family.pack.Family_Tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByCountOfChildren<T extends FamilyTreeItem<T>> implements Comparator<T> {

    public int compare(T o1, T o2){
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}
