package model.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import model.Humans.HumanComparatorByName;
import model.Humans.HumanComparatorByGender;

public class FamilyTree<U extends ItemFamilyTree<U>> implements Serializable, Iterable<U> {
    private int humID;
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

    public boolean addHuman(U human) {
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            human.setID(humID++);

            addToParents(human);
            addToChildren(human);
            return true;
        } else {
            humans.add(human);
            human.setID(humID++);

            addToParents(human);
            addToChildren(human);
        }
        return false;
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

    private void addToParents(U human) {
        U father = human.getFather();
        U mother = human.getMother();
        if (mother != null) {
            mother.addChild(human);
        }
        if (father != null) {
            father.addChild(human);
        }
    }

    private void addToChildren(U human) {
        for (U child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private boolean checkID(int ID) {
        return ID < humID && ID >= 0;
    }

    public U getByID(int humID) {
        if (!checkID(humID)) {
            return null;
        }
        for (U human : humans) {
            if (human.getID() == humID) {
                return human;
            }
        }
        return null;
    }
}
