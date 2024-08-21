package family_tree;

import family_tree.human.Human;

import java.util.Comparator;

public class ComparatorByAge<T extends FamilyTreeItem<T>>  implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
