package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> members;
    private int nextId;

    public FamilyTree() {
        this.members = new ArrayList<>();
        this.nextId = 0;
    }

    public void addMember(Human human) {
        human.setId(nextId++);
        members.add(human);
    }

    public Human findMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Human> getChildrenOf(Human parent) {
        return parent.getChildren();
    }

    public List<Human> getMembers() {
        return members;
    }
}
