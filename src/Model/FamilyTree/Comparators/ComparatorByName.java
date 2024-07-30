package Model.FamilyTree.Comparators;
import Model.Creature.Entity;

import java.util.Comparator;

public class ComparatorByName<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T creature_1, T creature_2) {
        if (creature_2.getName() == null && creature_1.getName() == null) return 0;

        if (creature_2.getName() == null) return -1;

        if (creature_1.getName() == null) return 1;

        return creature_2.getName().compareTo(creature_1.getName());
    }
}
