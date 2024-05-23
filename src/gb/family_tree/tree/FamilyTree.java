package gb.family_tree.tree;

import ru.gb.family_tree.humans.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public Human findByName(String nameHuman) {
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(nameHuman)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
