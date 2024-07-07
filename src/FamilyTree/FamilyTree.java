package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Humans.Human;
import Humans.HumanComparatorByName;
import Humans.HumanComparatorByGender;

public class FamilyTree implements Serializable, Iterable<Human> {
    // private int humID;
    private List<Human> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public Human getByName(String humanName) {
        for (Human human : humans) {
            if (human.getName().equals(humanName)) {
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Количество людей в дереве: ");
        sb.append(humans.size());
        sb.append("\n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyIterator(humans);
    }

    public void sortByName() {
        Collections.sort(humans, new HumanComparatorByName());
    }

    public void sortByGender() {
        Collections.sort(humans, new HumanComparatorByGender());
    }

}
