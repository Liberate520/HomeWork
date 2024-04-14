package family_tree;

import human.Human;
import human.comparator.HumanComparatorByAge;
import human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;
    private int id;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void add(Human human) {
        humanList.add(human);
        id++;
        human.setId(id);
    }

    public int getId() {
        return id;
    }

    public void sortByName(){
        Collections.sort(humanList, new HumanComparatorByName());
    }

    public void sortByAge(){
        Collections.sort(humanList, new HumanComparatorByAge());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}
