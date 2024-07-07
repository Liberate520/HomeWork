package FamilyTree;
import java.util.HashMap;
import java.util.Map;

import Human.Human;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<Integer, Human> humans;

    // Конструктор класса FamilyTree
    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    // Метод для добавления человека в дерево
    public void addHuman(Human human) {
        humans.put(human.getId(), human);
    }

    // Метод для получения человека по ID
    public Human getHuman(int id) {
        return humans.get(id);
    }

    // Метод для получения детей человека по ID
    public List<Human> getChildren(int id) {
        Human human = humans.get(id);
        return (human != null) ? human.getChildren() : new ArrayList<>();
    }

    public void printTree() {
        for (Human human : humans.values()) {
            System.out.println(human);
        }
    }
}


