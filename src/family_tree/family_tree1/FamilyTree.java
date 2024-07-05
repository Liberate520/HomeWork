package family_tree.family_tree1;

import family_tree.human.Human;
import family_tree.human.comparators.HumanComparatorByDateBirth;
import family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{

    private final List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman (Human human) {
        humans.add(human);
    }

    public List<Human> findHumansByName(String name) {
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : humans) {
            if (human.getName().equalsIgnoreCase(name)) {
                foundHumans.add(human);
            }
        }
        return foundHumans;
    }

    public Human findHumanById(int id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByName () {
        humans.sort(new HumanComparatorByName());
    }

    public void sortByDateBirth () {
        humans.sort(new HumanComparatorByDateBirth());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FamilyTree{humans=[\n");
        for (Human human : humans) {
            sb.append(human.toString()).append("\n");
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }
}
