import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<HumanAbsract> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(HumanAbsract human) {
        people.add(human);
    }

    public List<HumanAbsract> getPeople() {
        return people;
    }

    public HumanAbsract findHuman(String name) {
        for (HumanAbsract human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HumanAbsract human : people) {
            sb.append(human.getFullInfo()).append("\n");
    }
    return sb.toString();
}
}

