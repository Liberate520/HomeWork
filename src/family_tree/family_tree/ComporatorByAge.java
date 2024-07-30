package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Comparator;

public class ComporatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
