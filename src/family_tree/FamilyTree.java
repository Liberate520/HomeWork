package family_tree;

import family_tree.Iterators.HumanIterator;
import human.Human;
import human.comparator.HumanComparatorByAge;
import human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Human & FamilyTreeElement> implements Serializable, Iterable<E> {
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

    public void sortByName(){
        Collections.sort(humanList, new HumanComparatorByName<>());
    }

    public void sortByAge(){
        Collections.sort(humanList, new HumanComparatorByAge<>());
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
