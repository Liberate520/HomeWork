import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        people.add(human);
    }

    public List<Human> getPeople() {
        return people;
    }

    public Human findHuman(String name) {
        for (Human human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
}
