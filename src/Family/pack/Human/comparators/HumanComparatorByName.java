package Family.pack.Human.comparators;

import Family.pack.Family_Tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyTreeItem<T>> implements Comparator<T> {

    public int compare(T o1, T o2){
        return o1.getName().compareTo(o2.getName());
    }
}
