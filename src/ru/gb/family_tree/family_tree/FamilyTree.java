package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanComparatorById;
import ru.gb.family_tree.human.HumanIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int genId;

    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public void addHumans(List<Human> humans) {
        this.humans.addAll(humans);
    }

    public void sortByName(){
        Collections.sort(humans);
    }

    public List<Human> getHumans() {
        return humans;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }

    public void sortById() {
        Collections.sort(humans, new HumanComparatorById());
    }


    /**

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

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }


    */
}
