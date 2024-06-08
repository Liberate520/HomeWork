package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для представления генеалогического древа.
 */
public class FamilyTree implements Serializable {

    private Map<Integer, Human> humans;

    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    public void addHuman(Human human) {
        this.humans.put(human.getId(), human);
    }

    public void restoreRelationships() {
        for (Human human : humans.values()) {
            human.toString();
        }
    }

    public Map<Integer, Human> getHumans() {
        return humans;
    }
}