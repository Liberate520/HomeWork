package familytree;

import human.Human;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;
import iterators.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyTreeElement> implements Serializable, Iterable<T> {
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