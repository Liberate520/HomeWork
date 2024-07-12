package com.example.familytree;

import com.example.familytree.model.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public void removeMemberById(int id) {
        members.removeIf(member -> member.getId() == id);
    }

    public List<T> getAllMembers() {
        return members;
    }

    public void sortBy(Comparator<T> comparator) {
        Collections.sort(members, comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public T findPersonById(int id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void setParentChildRelation(int parentId, int childId) {
        T parent = findPersonById(parentId);
        T child = findPersonById(childId);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }
}
