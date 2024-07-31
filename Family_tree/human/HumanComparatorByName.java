package Family_tree.human;

import java.util.Comparator;

import Family_tree.family_tree.ItemFamilyTree;

public class HumanComparatorByName<T extends ItemFamilyTree> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());    
    }
    
}
