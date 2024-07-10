package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T getMemberById(int id) {
        for (T member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}
