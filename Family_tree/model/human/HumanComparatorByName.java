package Family_tree.model.human;

import java.util.Comparator;

import Family_tree.model.family_tree.ItemFamilyTree;

public class HumanComparatorByName<T extends ItemFamilyTree> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());    
    }
    
}
