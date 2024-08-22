package GB_Homework.Model.Family_Tree.Comporators;

import GB_Homework.Model.Family_Tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByBirthDate<T extends ItemFamilyTree> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
