import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public Human getReadName(String nameHuman){
        for (Human human: humans){
            if (human.getName().equals(nameHuman)){
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:");
        for (Human human : humans){
            stringBuilder.append("\n\n");
            stringBuilder.append(human);
        }
        return stringBuilder.toString();
    }

}
