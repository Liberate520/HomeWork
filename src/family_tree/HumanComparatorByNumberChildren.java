package family_tree;

import Creatures.Creature;
import Creatures.Human;

import java.util.Comparator;

public class HumanComparatorByNumberChildren <T extends Creature<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}
