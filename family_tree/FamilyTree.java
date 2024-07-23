package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import human.Human;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
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
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : this.familyTree) {
            result.append(human.toString());
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }
}