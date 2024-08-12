package ru.gb.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public int size(){
        return humans.size();
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public Human getById(int id){
        for (Human human : humans) {
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо: \n");
        for (Human human : humans) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
}
