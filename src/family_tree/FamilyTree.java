package family_tree;
import human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.familyTree.add(human);
    }

    public String findHuman(String name) {
        String result = "";
        for (int i = 0; i < this.familyTree.size(); i++) {
            if (this.familyTree.get(i).getName().equals(name)) {
                result += familyTree.get(i).toString();
            } else {
                result += String.format("Имя %s не найдено!", name);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : this.familyTree) {
            result.append(human.toString());
            result.append("\n");
        }
        return result.toString();
    }
}