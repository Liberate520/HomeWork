package model;

import java.io.Serializable;
import java.util.*;

public class FamilyTree <T extends FamilyMember> implements Iterable<T>, Serializable {

    private final Map<String, T> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(T human) {
        members.put(human.getName(), human);
    }

    public T getMember(String name) {
        return members.get(name);
    }

    public List<T> getChildrenOf(String name) {
        T parent = getMember(name);
        return parent != null ? (List<T>) parent.getChildren() : new ArrayList<>();
    }

    public List<T> getParentsOf(String name) {
        T child = getMember(name);
        return child != null ? (List<T>) child.getParents() : new ArrayList<>();
    }

    public List<T> getMembers() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Iterator<T> iterator() {
        return members.values().iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T member : members.values()) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }

}
