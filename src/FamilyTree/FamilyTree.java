package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import Humans.HumanComparatorByName;
import Humans.HumanComparatorByGender;

public class FamilyTree<U extends ItemFamilyTree> implements Serializable, Iterable<U> {
    // private int humID;
    private List<U> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<U> humans) {
        this.humans = humans;
    }

    public U getByName(String humanName) {
        for (U human : humans) {
            if (human.getName().equals(humanName)) {
                return human;
            }
        }
        return null;
    }

    public void addHuman(U human) {
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
        for (U human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<U> iterator() {
        return new FamilyIterator<>(humans);
    }

    public void sortByName() {
        Collections.sort(humans, new HumanComparatorByName<>());
    }

    public void sortByGender() {
        Collections.sort(humans, new HumanComparatorByGender<>());
    }

}
