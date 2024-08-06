package familytree.human;

import familytree.human.Human;
import java.util.Comparator;
import familytree.family_tree.TreeElement;

public class HumanAgeComparator<T extends TreeElement> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2) {
        return Integer.compare(h2.calculateAge(), h1.calculateAge());
    }
}