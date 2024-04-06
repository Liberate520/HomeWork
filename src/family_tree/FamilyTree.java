package family_tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    List<Human> humanList;
    int id;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void add(Human human) {
        humanList.add(human);
        id++;
        human.setId(id);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
