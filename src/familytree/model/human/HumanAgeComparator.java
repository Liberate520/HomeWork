package familytree.model.human;

import familytree.model.human.Human;
import java.util.Comparator;
import familytree.model.family_tree.TreeElement;

public class HumanAgeComparator<T extends TreeElement<T>> implements Comparator<T> {
    @Override
    public int compare(T h1, T h2) {
        return Integer.compare(h2.calculateAge(), h1.calculateAge());
    }
}