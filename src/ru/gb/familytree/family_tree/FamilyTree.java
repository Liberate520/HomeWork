package ru.gb.familytree.family_tree;

import ru.gb.familytree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public String getHumansInfo(){
        StringBuilder result = new StringBuilder();
        for (Human human: humans){
            result.append(getInfo(human));
            result.append("\n");
        }
        return result.toString();
    }
    public String getHumansChildrenInfo(int selectId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей для ")
                .append(humans.get(selectId-1).getName())
                .append(":\n");

        for(Human human : humans){
            if (human.getFather() != null) {
                if (human.getFather().getId() == selectId) {
                    stringBuilder.append(human.getName()).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    private String getInfo(Human human) {
        StringBuilder result = new StringBuilder();
        result.append(human.getId())
                .append(", Имя: ").append(human.getName())
                .append(", пол: ").append(human.getGender())
                .append(", дата рождения: ").append(human.getBirthDay())
                .append(", дата смерти: ").append(human.getDeathData());
        if (human.getFather() == null) {
            result.append(", отец: ").append("неизвестен");
        } else {
            result.append(", отец: ").append(human.getFather().getName());
        }
        if (human.getMother() == null) {
            result.append(", мать: ").append("неизвестена");
        } else {
            result.append(", мать: ").append(human.getMother().getName());
        }
        return result.toString();
    }
}
