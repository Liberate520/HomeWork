package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human>, Serializable {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.people.add(human);
    }

    public List<Human> getPeople() {
        return people;
    }

    public List<Human> getChildrenOf(Human human) {
        return human.getChildren();
    }

    public Human findHumanByName(String name) {
        for (Human human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getParentsOf(Human human) {
        return human.getParents();
    }

    @Override
    public Iterator<Human> iterator() {
        return people.iterator();
    }
}