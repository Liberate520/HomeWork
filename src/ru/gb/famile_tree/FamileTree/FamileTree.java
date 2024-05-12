package ru.gb.famile_tree.FamileTree;

import ru.gb.famile_tree.Human.Human;

import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;

public class FamileTree implements Serializable{
    private TreeMap<LocalDate, Human> humanByBirthDate;
    private Map<String, Human> humanByName;
    private Set<String> addedHuman;

    public FamileTree() {
        this.humanByBirthDate = new TreeMap<>();
        this.humanByName = new HashMap<>();
        this.addedHuman = new HashSet<>();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, String parentName) {
        if (addedHuman.contains(name)) {
            System.out.println("Человек с именем " + name + " уже добавлен в дерево.");
            return;
        }
        Human human = new Human(name, birthDate, deathDate);
        humanByBirthDate.put(birthDate, human);
        humanByName.put(name, human);
        addedHuman.add(name);
        if (parentName != null) {
            Human parent = humanByName.get(parentName);
            if (parent != null) {
                parent.addChild(human);
            } else {
                System.out.println("Родитель " + parentName + " не найден. " + name + " будет добавлен как корень дерева.");
            }
        }
    }

    public Human findHuman(String name) {
        for (Human human : humanByName.values()) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void printTree() {
        for (Human human : humanByBirthDate.values()) {
            printHuman(human, 0);
        }
    }

    private void printHuman(Human human, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  "); // Два пробела на каждый уровень
        }
        sb.append(human.getName()).append(" (").append(human.getBirthDate()).append(" - ");
        if (human.getDeathDate() != null) {
            sb.append(human.getDeathDate());
       }
//        else {
//            sb.append("сейчас");
//        }
        sb.append("), ").append(human.getAge());
        if ((human.getAge() % 10) == 1) sb.append(" год");
        if ((human.getAge() % 10) > 1 && (human.getAge() % 10) < 5 ) sb.append(" года");
        if ((human.getAge() % 10) == 0 || (human.getAge() % 10) > 4 ) sb.append((" лет"));
        System.out.println(sb.toString());
        for (Human child : human.getChildren()) {
            printHuman(child, level + 1);
        }
    }
}
