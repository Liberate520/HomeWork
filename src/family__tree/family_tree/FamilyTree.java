package family__tree.family_tree;

import family__tree.human.HumanComparatorByBirth;
import family__tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemFamilyTree> implements Serializable, Iterable<E> {

    private static final long serialVersionUID = 1L;

    private List<E> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(E human) {
        humans.add(human);
    }

    public void addHumans(List<E> humans) {
        this.humans.addAll(humans);
    }

    public List<E> getChildren(E person) {
        return person.getChildren();
    }

    public void removeHuman(E human) {
        humans.remove(human);
        for (E parent : humans) {
            if (parent.getChildren().contains(human)) {
                parent.getChildren().remove(human);
            }
        }
    }

    public List<E> getAllHumans() {
        return humans;
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByBirth<>());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо:\n");
        for (E human : humans) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return humans.iterator();
    }
}