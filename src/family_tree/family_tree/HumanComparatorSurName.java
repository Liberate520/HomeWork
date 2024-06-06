package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorSurName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurName().compareTo(o2.getSurName());
    }
}