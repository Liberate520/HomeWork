package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman (Human human) {
        humans.add(human);
    }

    public List<Human> getHumans() {
        return humans;
    }

    public List<Human> findHumansByName(String name) {
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : humans) {
            if (human.getName().equalsIgnoreCase(name)) {
                foundHumans.add(human);
            }
        }
        return foundHumans;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humans=" + humans +
                '}';
    }
}
