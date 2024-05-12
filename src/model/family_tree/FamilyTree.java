package model.family_tree;

import model.family_tree.Iterators.HumanIterator;
import model.human.comparator.HumanComparatorByAge;
import model.human.comparator.HumanComparatorById;
import model.human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E>, FamilyTreeElement{
    private List<E> humanList;
    private int id;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public int getID() {
        return 0;
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

    @Override
    public int add(Object human) {
        humanList.add((E) human);
        id++;
        ((FamilyTreeElement<?>) human).setId(id);
        return id;
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
    public void addParent(Object search) {

    }

    @Override
    public void addChild(Object search) {

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
