package family_tree.humans.comparators;

import family_tree.humans.Human;

import java.util.Comparator;

public class HumanComparatorByDeathDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDeathDate().compareTo(o2.getDeathDate());
    }
}
