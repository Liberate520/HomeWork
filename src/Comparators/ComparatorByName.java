package Comparators;

import Creature.Creature;

import java.util.Comparator;

public class ComparatorByName<T extends Creature<T>> implements Comparator<T> {

    @Override
    public int compare(T creature_1, T creature_2) {
        return creature_1.getName().compareTo(creature_2.getName());
    }
}
