package Model.Human.comparators;



import Model.FamilyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2){
        return Integer.compare((int) o1.getAge(), (int) o2.getAge());
    }

}
