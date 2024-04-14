package familytree.model.familytree;

import familytree.model.human.comparators.HumanComparatorByAge;
import familytree.model.human.comparators.HumanComparatorByName;
import familytree.model.human.iterators.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyTreeElement<T>> implements Serializable, Iterable<T> {
    private final List<T> familyTree;


    public FamilyTree() {familyTree = new ArrayList<>();}

    public void add(T human) {
        familyTree.add(human);
    }

    public List<T> getList() {
        return familyTree;
    }

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }
}