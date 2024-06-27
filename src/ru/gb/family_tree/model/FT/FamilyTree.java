package ru.gb.family_tree.model.FT;

import ru.gb.family_tree.model.Human.comparator.ComparatorByBirthDate;
import ru.gb.family_tree.model.Human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;

    private List<T> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(T human){
        humanList.add(human);
        System.out.println("Human added: " + human.getName());
    }

    public List<T> getHumanList() {
        return humanList;
    }

    public T findHumanByName(String nameHuman){
        for (T human : humanList){
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
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }

    @Override
    public String toString() {
        return "Древо семьи{" +
                "Список членов семьи: " + humanList +
                '}';
    }

}
