package family_tree.comparator;

import family_tree.creators.Creators;

import java.util.Comparator;

public class CreatorComparatorByName implements Comparator<Creators> {
    @Override
    public int compare(Creators o1, Creators o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
