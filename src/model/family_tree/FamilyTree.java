package model.family_tree;

import model.family_tree.Iterators.HumanIterator;
import model.human.Element;
import model.human.comparator.HumanComparatorByAge;
import model.human.comparator.HumanComparatorById;
import model.human.comparator.HumanComparatorByName;


import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends Element<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;
    private int id;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public int add(E human) {
        humanList.add((E) human);
        id++;
        human.setId(id);
        return id;
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

    //
    public void sortByName() {
        Collections.sort(humanList, new HumanComparatorByName<>());
    }


    public void sortByAge() {
        Collections.sort(humanList, new HumanComparatorByAge<>());
    }


    public void sortByID() {
        Collections.sort(humanList, new HumanComparatorById<>());
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
