package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.iterator.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public Human getReadName(String nameHuman) {
        for (Human human : humans) {
            if (human.getName().equals(nameHuman)) {
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public List<Human> getHumans() {
        return humans;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:");
        for (Human human : humans) {
            stringBuilder.append("\n\n");
            stringBuilder.append(human.getBasicInfo());
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humans);
    }
}