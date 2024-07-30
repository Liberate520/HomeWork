package Model.FamilyTree.Comparators;
import Model.Creature.Entity;

import java.util.Comparator;

public class ComparatorByID<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T creature_1, T creature_2) {
        return creature_2.getID() - creature_1.getID();
    }
}
