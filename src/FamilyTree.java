import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Human> people;
    public FamilyTree() {
        this.people = new ArrayList<>();
    }
    public void addHuman(Human human) {
        this.people.add(human);
    }

    public Human findHumanByName(String name) {
        for (Human human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getChildrenOf(Human human) {
        return human.getChildren();
    }
}