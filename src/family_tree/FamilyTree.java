package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<Human> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addHuman (Human human) {
        members.add(human);
    }

    public List<Human> findHumansByName(String name) {
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : members) {
            if (human.getName().equalsIgnoreCase(name)) {
                foundHumans.add(human);
            }
        }
        return foundHumans;
    }

    public Human findHumanById(int id) {
        for (Human human : members) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humans=" + members +
                '}';
    }
}
