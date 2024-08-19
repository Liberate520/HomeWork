package GB_FamilyTree.Family_Tree.Human;

import GB_FamilyTree.Family_Tree.Family_Tree.Item;

import java.util.Comparator;

public class HumanComparatorByName <T extends Item>  implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
