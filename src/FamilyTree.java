import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humans) {
            sb.append(human.toString()).append("\n");
        }
        return sb.toString();
    }
}
