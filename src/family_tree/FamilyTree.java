package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }
    public void addHuman(Human human) {
        familyTree.add(human);
    }
    public Human findHuman(String name) {
        for (Human human : familyTree) {
            if ( human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        } return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Генеалогическое древо семьи:\n");
        for (Human human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
