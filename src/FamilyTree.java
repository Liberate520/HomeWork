import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(Human human) {
        members.add(human);
    }

    public Human findPersonByName(String name) {
        for (Human human : members) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getParentsOf(String name) {
        Human human = findPersonByName(name);
        if (human != null) {
            return human.getParents();
        }
        return null;
    }

    public List<Human> getChildrenOf(String name) {
        Human human = findPersonByName(name);
        if (human != null) {
            return human.getChildren();
        }
        return null;
    }

    public List<Human> getAllMembers() {
        return members;
    }

    public void printAllMembers() {
        for (Human human : members) {
            System.out.println(human);
        }
    }

    public void sortByName() {
        Collections.sort(members, new HumanComporatorByName());
    }

    public void sortByBirthDate() {
        Collections.sort(members, new HumanComporatorByBirthDate());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(members);
    }
}