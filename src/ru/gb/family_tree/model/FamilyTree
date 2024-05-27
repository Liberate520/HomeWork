package ru.gb.family_tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long idHuman;
    private final List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) return false;
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId((idHuman++));

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParents(human);
        }
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public List<Human> findByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> findByLastName(String lastName) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getLastName().equals(lastName)) {
                res.add(human);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В нашей семье ");
        sb.append(idHuman);
        sb.append(" членов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        Collections.sort(humanList, (h1, h2) -> h1.getName().compareTo(h2.getName()));
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, (h1, h2) -> h1.getDob().compareTo(h2.getDob()));
    }
}

