package module.lesson2.sortHuman;

import module.lesson2.familytree.Creature;
import module.lesson2.human.Human;

import java.util.Comparator;

public class HumanCompareSortByAge<E extends Creature<Human>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.howManyYears(o1.getDateDeath(), o1.getDateBirth()),o2.howManyYears(o2.getDateDeath(), o2.getDateBirth()));
    }
}
