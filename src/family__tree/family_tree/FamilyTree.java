package family__tree.family_tree;

import family__tree.human.Human;
import family__tree.human.HumanComparatorByBirth;
import family__tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>  {

    private static final long serialVersionUID = 1L;

    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public void addHumans(List<Human> humans) {
        this.humans.addAll(humans);
    }

    public List<Human> getAllChildren(Human parent) {
        return parent.getChildren();
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByBirth());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо:\n");
        for (Human human : humans) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }
}