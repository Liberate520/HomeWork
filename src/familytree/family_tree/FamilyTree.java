package familytree.family_tree;

import familytree.human.Human;
import familytree.human.Gender;
import familytree.human.HumanAgeComparator;
import familytree.human.HumanNameComparator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public Human findHuman(String name) {
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getAllHumans() {
        return humans;
    }

    public List<Human> getChildrenOf(String name) {
        Human human = findHuman(name);
        if (human != null) {
            return human.getChildren();
        }
        return new ArrayList<>();
    }

    public List<Human> getParentsOf(String name) {
        Human human = findHuman(name);
        if (human != null) {
            return human.getParents();
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humans) {
            sb.append(human.toString()).append("\n");
        }
        return sb.toString();
    }
  
    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humans);
    }


    public void sortByName() {
        Collections.sort(humans, new HumanNameComparator());
    }

    public void sortByAge() {
        Collections.sort(humans, new HumanAgeComparator());
    }

}
