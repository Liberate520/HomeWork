package homeWork.family_tree.family;

import homeWork.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }
    public void addHuman(Human human) {
        humanList.add(human);
    }
    public Human findNameOfPeople(String nameHuman) {
        for (Human human: humanList) {
            if (human.getName().equals(nameHuman)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево: \n");

        for (Human human: humanList) {
            stringBuilder.append(human);
        }
        return stringBuilder.toString();
    }
}
