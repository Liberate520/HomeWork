import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.people.add(human);
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
}