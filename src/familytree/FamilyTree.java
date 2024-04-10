package familytree;

import human.Human;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;
import iterators.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private final List<Human> familyTree;


    public FamilyTree() {familyTree = new ArrayList<>();}

    public void add(Human human) {
        familyTree.add(human);
    }

    public List<Human> getList() {
        return familyTree;
    }

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }
}