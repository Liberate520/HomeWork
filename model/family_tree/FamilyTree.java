package model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByGender;
import model.human.comparators.HumanComparatorByName;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(E human) {
        this.familyTree.add(human);
    }

    public String findHuman(String name) {
        String result = "";
        for (int i = 0; i < this.familyTree.size(); i++) {
            if (this.familyTree.get(i).getName().equals(name)) {
                result += familyTree.get(i).toString();
            } else {
                result += String.format("Человек с именем %s не найден!", name);
            }
        }
        return result;
    }

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge<>());
    }

    public void sortByGender() {
        familyTree.sort(new HumanComparatorByGender<>());
    }

    public boolean isInFamilyTree(int id) {
        for (E human : this.familyTree) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getHumanById(int id) {
        for (E human : this.familyTree) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (E human : this.familyTree) {
            result.append(human.toString());
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }
}