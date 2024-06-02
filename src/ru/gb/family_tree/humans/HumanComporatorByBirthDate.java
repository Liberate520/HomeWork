package ru.gb.family_tree.humans;

import java.util.Comparator;

public class HumanComporatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDate_of_birth().compareTo(o2.getDate_of_birth());
    }
}
