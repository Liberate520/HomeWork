package model.human.human_manager;

import model.human.Gender;
import model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanRelationshipManager {
    private final Human human;

    public HumanRelationshipManager(Human human) {
        this.human = human;
    }

    public boolean addChild(Human child) {
        if (!human.getChildren().contains(child)) {
            human.getChildren().add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender() == Gender.Male) {
            human.setFather(parent);
        } else if (parent.getGender() == Gender.Female) {
            human.setMother(parent);
        }
        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (human.getFather() != null) {
            list.add(human.getFather());
        }
        if (human.getMother() != null) {
            list.add(human.getMother());
        }
        return list;
    }
}
