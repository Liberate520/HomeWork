import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
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
}