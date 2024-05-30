package ru.gb.family_tree.FT;

import ru.gb.family_tree.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }
    public void addHuman(Human human){
        humanList.add(human);
    }


    public List<Human> getHumanList() {
        return humanList;
    }

    public Human findHumanByName(String nameHuman){
        for (Human human : humanList){
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
