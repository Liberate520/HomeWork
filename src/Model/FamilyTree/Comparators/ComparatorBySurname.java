package Model.FamilyTree.Comparators;
import Model.Creature.Entity;

import java.util.Comparator;

public class ComparatorBySurname<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T creature_1, T creature_2) {
        if (creature_2.getSurname() == null && creature_1.getSurname() == null) return 0;

        if (creature_2.getSurname() == null) return -1;

        if (creature_1.getSurname() == null) return 1;

        return  creature_2.getSurname().compareTo(creature_1.getSurname());
    }
}
