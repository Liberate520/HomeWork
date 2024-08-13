package Model.FamilyTree.Comparators;
import Model.Creature.Entity;

import java.util.Comparator;

public class ComparatorByChildren<T extends Entity> implements Comparator<T> {
    @Override
    public int compare(T creature_1, T creature_2) {
        return creature_2.getChildren().size() - creature_1.getChildren().size();
    }
}
