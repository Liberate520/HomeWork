package familytree.human;

import familytree.human.Human;
import java.util.Comparator;
import familytree.family_tree.TreeElement;

public class HumanNameComparator<T extends TreeElement> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2) {
        return h1.getName().compareTo(h2.getName());
    }
}