package family_tree.family_tree;


import family_tree.human.Gender;
import family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.people.add(human);
    }

    public Human findHumanByName(String name) {
        for (Human human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void addParentChildRelation(String parentName, String childName) {
        Human parent = findHumanByName(parentName);
        Human child = findHumanByName(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
            if (parent.getGender() == Gender.мужской) {
                child.setFather(parent);
            } else {
                child.setMother(parent);
            }
        }
    }

    public List<Human> getChildrenOf(String name) {
        Human human = findHumanByName(name);
        if (human != null) {
            return human.getChildren();
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево: \n");
        for (Human human : people) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}



