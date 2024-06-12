package OOP.SemDZ.homeWork.model.comparator;

import java.util.Comparator;

import OOP.SemDZ.homeWork.model.human.Creature;

public class HumanComparatorByName<T extends Creature> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
