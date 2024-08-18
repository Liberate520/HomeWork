package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(T human) {
        members.add(human);
    }

    public T findPersonByName(String name) {
        for (T human : members) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public List<T> getParentsOf(String name) {
        T human = findPersonByName(name);
        if (human != null) {
            return (List<T>) human.getParents();
        }
        return null;
    }

    public List<T> getChildrenOf(String name) {
        T human = findPersonByName(name);
        if (human != null) {
            return (List<T>) human.getChildren();
        }
        return null;
    }

    public List<T> getAllMembers() {
        return members;
    }

    public void printAllMembers() {
        for (T human : members) {
            System.out.println(human);
        }
    }

    public void sortByName() {
        Collections.sort(members, new HumanComporatorByName<T>());
    }

    public void sortByBirthDate() {
        Collections.sort(members, new HumanComporatorByBirthDate<T>());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(members);
    }
}