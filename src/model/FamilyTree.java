package model;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Iterable<Human>, Serializable {

    private final Map<String, Human> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(Human human) {
        members.put(human.getName(), human);
    }

    public Human getMember(String name) {
        return members.get(name);
    }

    public List<Human> getChildrenOf(String name) {
        Human parent = getMember(name);
        return parent != null ? parent.getChildren() : new ArrayList<>();
    }

    public List<Human> getParentsOf(String name) {
        Human child = getMember(name);
        return child != null ? child.getParents() : new ArrayList<>();
    }

    public List<Human> getMembers() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Iterator<Human> iterator() {
        return members.values().iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human member : members.values()) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }

}
