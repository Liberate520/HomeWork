package family__tree.model.human;

import family__tree.model.family_tree_service.ItemFamilyTree;

import java.util.Comparator;


public class HumanComparatorByName<T extends ItemFamilyTree> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


