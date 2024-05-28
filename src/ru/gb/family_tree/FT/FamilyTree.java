package ru.gb.family_tree.FT;

import ru.gb.family_tree.Human.Gender;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Gender.Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }
    public void addHuman(Gender.Human human){
        humanList.add(human);
    }

    public List<Gender.Human> getHumanList() {
        return humanList;
    }
    public Gender.Human findHumanByName(String nameHuman){
        for (Gender.Human human : humanList){
            if(human.getName().equalsIgnoreCase(nameHuman)){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humanList=" + humanList +
                '}';
    }

}
