package ru.gb.familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends HumanInfo> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }

    public void sortByName() {
        Collections.sort(members, (m1, m2) -> m1.getName().compareTo(m2.getName()));
    }

    public void sortByDob() {
        Collections.sort(members, (m1, m2) -> m1.getDob().compareTo(m2.getDob()));
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}