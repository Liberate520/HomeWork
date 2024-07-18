package ru.gb.familytree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human){
        humans.add(human);
    }
    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String getHumansChildrenInfo(int selectId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей для " + humans.get(selectId-1).getName() + ":\n");

        for(Human human : humans){
            if (human.getFather() != null) {
                if (human.getFather().getId() == selectId) {
                    stringBuilder.append(human).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
