package ru.as.family_tree.generation_tree;


import ru.as.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public int size() {
        return humans.size();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }


    @Override

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо: ").append("\n");
        if (!humans.isEmpty()) {
            stringBuilder.append(humans.get(0)).append("\n");
            stringBuilder.append("---------------------------------------------------------");
            stringBuilder.append("\n");
            if (humans.size() > 2) {
                stringBuilder.append("Родители: ").append("\n");
                stringBuilder.append(humans.get(1)).append("\n");
                stringBuilder.append(humans.get(2)).append("\n");
                stringBuilder.append("---------------------------------------------------------");
                stringBuilder.append("\n");
            }
            if (humans.size() > 4) {
                stringBuilder.append("Родители мамы: ").append("\n");
                stringBuilder.append(humans.get(3)).append("\n");
                stringBuilder.append(humans.get(4)).append("\n");
                stringBuilder.append("---------------------------------------------------------");
                stringBuilder.append("\n");
            }
            if (humans.size() > 6) {
                stringBuilder.append("Родители папы: ").append("\n");
                stringBuilder.append(humans.get(5)).append("\n");
                stringBuilder.append(humans.get(6)).append("\n");
                stringBuilder.append("---------------------------------------------------------");
                stringBuilder.append("\n");
            }

        }
            return stringBuilder.toString();
    }
}