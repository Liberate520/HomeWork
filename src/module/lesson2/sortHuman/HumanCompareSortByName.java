package module.lesson2.sortHuman;

import module.lesson2.familytree.Creature;
import module.lesson2.human.Human;

import java.util.Comparator;

public class HumanCompareSortByName <E extends Creature<Human>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
