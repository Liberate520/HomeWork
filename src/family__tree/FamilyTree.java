package family__tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
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

    @Override
    public String toString() {
        return "Семейное древо: " + humans;
    }
}