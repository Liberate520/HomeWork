package model.family_tree;

import model.family_tree.Iterators.HumanIterator;
import model.human.Element;
import model.human.comparator.HumanComparatorByAge;
import model.human.comparator.HumanComparatorById;
import model.human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Element<E>> implements Serializable, Iterable<E>, Tree {
    private List<E> humanList;
    private int id;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addParent(int child, int parent) {
        for (E human : humanList) {
            if (human.getID() == child) {
                human.addParent(search(parent));
            }
        }
    }

    public void addChild(int child, int parent) {
        for (E human : humanList) {
            if (human.getID() == parent) {
                human.addChild(search(child));
            }
        }
    }

    public E search(int id) {
        for (E human : humanList) {
            if (human.getID() == id) {
                return human;
            }
        }
        return null;
    }

    public boolean availability(int id) {
        for (E human : humanList) {
            if (human.getID() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int add(Object human) {
        humanList.add((E) human);
        id++;
        ((Element<?>) human).setId(id);
        return id;
    }

    @Override
    public void sortByName() {
        Collections.sort(humanList, new HumanComparatorByName<>());
    }

    @Override
    public void sortByAge() {
        Collections.sort(humanList, new HumanComparatorByAge<>());
    }

    @Override
    public void sortByID() {
        Collections.sort(humanList, new HumanComparatorById<>());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }
}
