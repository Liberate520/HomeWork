package model.family_tree;

import model.family_tree.Iterators.HumanIterator;
import model.human.Human;
import model.human.comparator.HumanComparatorByAge;
import model.human.comparator.HumanComparatorById;
import model.human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;
    private int id;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void add(E human) {
        humanList.add(human);
        id++;
        human.setId(id);
    }

    public int getId() {
        return id;
    }

    public void sortByName() {
        Collections.sort(humanList, new HumanComparatorByName<>());
    }

    public void sortByAge() {
        Collections.sort(humanList, new HumanComparatorByAge<>());
    }

    public void sortByID() {
        Collections.sort(humanList, new HumanComparatorById<>());
    }

    public Human search(int id) {
        for (E human: humanList) {
            if (human.getID() == id){
                return (Human) human;
            }
        }
        System.out.println("Не найден");
        return null;
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
