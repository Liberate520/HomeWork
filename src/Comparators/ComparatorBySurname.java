package Comparators;

import Creature.Creature;

import java.util.Comparator;

public class ComparatorBySurname<T extends Creature<T>> implements Comparator<T> {

    @Override
    public int compare(T creature_1, T creature_2) {
        return  creature_2.getSurname().compareTo(creature_1.getSurname());
    }
}
