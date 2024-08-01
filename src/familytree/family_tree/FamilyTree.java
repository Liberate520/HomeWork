package familytree.family_tree;

import familytree.human.Human;
import familytree.human.Gender;
import familytree.human.HumanAgeComparator;
import familytree.human.HumanNameComparator;
import familytree.family_tree.TreeElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeElement<E>> implements Serializable, Iterable<E> {
    private List<E> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(E human) {
        humans.add(human);
    }

    public E findHuman(String name) {
        for (E human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<E> getAllHumans() {
        return humans;
    }

    public List<E> getChildrenOf(String name) {
        E human = findHuman(name);
        if (human != null) {
            return (List<E>) human.getChildren(); 
        }
        return new ArrayList<>();
    }

    public List<E> getParentsOf(String name) {
        E human = findHuman(name);
        if (human != null) {
            return (List<E>) human.getParents();
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E human : humans) {
            sb.append(human.toString()).append("\n");
        }
        return sb.toString();
    }
  
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humans);
    }


    public void sortByName() {
        Collections.sort(humans, new HumanNameComparator<>());
    }

    public void sortByAge() {
        Collections.sort(humans, new HumanAgeComparator<>());
    }

}