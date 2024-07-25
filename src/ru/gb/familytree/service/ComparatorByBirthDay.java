package ru.gb.familytree.service;

import ru.gb.familytree.human.Human;

import java.util.Comparator;

public class ComparatorByBirthDay implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
