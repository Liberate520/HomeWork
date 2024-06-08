package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для представления генеалогического древа.
 */
public class FamilyTree implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<Integer, Human> humans;

    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    public void addHuman(Human human) {
        this.humans.put(human.getId(), human);
    }

    /**
     * Восстанавливает связи между людьми после десериализации.
     */
    public void restoreRelationships() {
        for (Human human : humans.values()) {
            for (Human mother : human.getMothers()) {
                mother.addChild(human);
            }
            for (Human father : human.getFathers()) {
                father.addChild(human);
            }
            if (human.getSpouse() != null) {
                human.getSpouse().setSpouse(human);
            }
        }
    }

    public Map<Integer, Human> getHumans() {
        return humans;
    }
}
