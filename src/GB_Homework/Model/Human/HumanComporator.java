package GB_Homework.Model.Human;

import GB_Homework.Model.Family_Tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComporator<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
