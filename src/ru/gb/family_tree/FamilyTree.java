package ru.gb.family_tree;

import ru.gb.family_tree.models.Human;
import ru.gb.family_tree.interfaces.MyIterable;

import java.io.Serializable;
import java.util.*;

// Класс, описывающий генеалогическое дерево
public class FamilyTree implements Serializable, MyIterable<Human> {
    private static final long serialVersionUID = 1L;

    private Map<Integer, Human> humans;
    private int nextId;

    public FamilyTree() {
        this.humans = new HashMap<>();
        this.nextId = 1;
    }

    public void addHuman(String name, String birthDate, String gender) {
        Human newHuman = new Human(nextId++, name, birthDate, gender);
        humans.put(newHuman.getId(), newHuman);
    }

    public Human getHuman(String name) {
        return humans.values().stream()
                .filter(human -> human.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addChild(String parentName, String childName) {
        Human parent = getHuman(parentName);
        Human child = getHuman(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    public List<Human> getChildren(String parentName) {
        Human parent = getHuman(parentName);
        if (parent != null) {
            return parent.getChildren();
        }
        return new ArrayList<>();
    }

    public void setDeathDate(String name, String deathDate) {
        Human human = getHuman(name);
        if (human != null) {
            human.setDeathDate(deathDate);
        }
    }

    public void setSpouse(String name1, String name2) {
        Human human1 = getHuman(name1);
        Human human2 = getHuman(name2);
        if (human1 != null && human2 != null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    public String displayFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humans.values()) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    public List<Human> getAllHumans() {
        return new ArrayList<>(humans.values());
    }

    public List<Human> sortByBirthDate() {
        List<Human> sortedList = new ArrayList<>(humans.values());
        sortedList.sort(Comparator.comparing(Human::getBirthDate));
        return sortedList;
    }

    public List<Human> sortById() {
        List<Human> sortedList = new ArrayList<>(humans.values());
        sortedList.sort(Comparator.comparingInt(Human::getId));
        return sortedList;
    }

    // Реализация интерфейса MyIterable
    @Override
    public Iterator<Human> iterator() {
        return humans.values().iterator();
    }
}
