package family_tree.model.family_tree1;

import family_tree.model.human.comparators.HumanComparatorByDateBirth;
import family_tree.model.human.comparators.HumanComparatorByName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemFamilyTree> implements Serializable, Iterable<E>{

    private final List<E> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman (E human) {
        humans.add(human);
    }

    public void sortByName () {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByDateBirth () {
        humans.sort(new HumanComparatorByDateBirth<>());
    }

    public E findHumanById(int id) {
        for (E human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> findHumansByName(String name) {
        List<E> foundHumans = new ArrayList<>();
        for (E human : humans) {
            if (human.getName().equalsIgnoreCase(name)) {
                foundHumans.add(human);
            }
        }
        return foundHumans;
    }

    public List<E> getHumans() {
        return humans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FamilyTree{humans=[\n");
        for (E human : humans) {
            sb.append(human.toString()).append("\n");
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }
}
