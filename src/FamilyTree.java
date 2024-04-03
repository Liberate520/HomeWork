import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int id_human;
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
        id_human = 1;
    }

    public void addHuman(Human human) {
        human.setId(id_human++);
        humanList.add(human);
    }

    public String getTreeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список персон: \n");
        for (Human human: humanList) {
            sb.append(human.getFullInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}