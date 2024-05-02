package model.family_tree;

import model.family_tree.Iterators.MembersIterator;
import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E>{

    private final List<E> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(E member) {
        if (!(member == null) && !family.contains(member)) {
            this.family.add(member);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MembersIterator<>(family);
    }

    public void sortByName() {
        family.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        family.sort(new HumanComparatorByAge<>());
    }
}