import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> list;

    public FamilyTree() {
        list = new ArrayList<>();
    }

    public void addHuman(Human human) {
        list.add(human);
    }

    public List<Human> getHumanChildren(Human human) {
        if(human.getChildren() != null){
            return human.getChildren();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Древо семьи: \n");
        for (Human human : list) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}