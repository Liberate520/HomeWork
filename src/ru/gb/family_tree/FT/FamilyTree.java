package ru.gb.family_tree.FT;

import ru.gb.family_tree.ComparatorByBirthDate;
import ru.gb.family_tree.Human.Human;
import ru.gb.family_tree.Human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
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

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByBirthDate(){
        humanList.sort(new ComparatorByBirthDate());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    @Override
    public String toString() {
        return "Древо семьи{" +
                "Список членов семьи: " + humanList +
                '}';
    }

}
