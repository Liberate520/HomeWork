package ru.marat.geekbrains.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Iterable<T> {
    private List<T> members;
    private ParentChildRelationship<T> relationship;

    public FamilyTree(ParentChildRelationship<T> relationship) {
        this.members = new ArrayList<>();
        this.relationship = relationship;
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getChildren(T parent) {
        List<T> children = new ArrayList<>();
        for (T member : members) {
            if (relationship.getMother(member) == parent || relationship.getFather(member) == parent) {
                children.add(member);
            }
        }
        return children;
    }

    public void sortByName(Comparator<T> nameComparator) {
        members.sort(nameComparator);
    }

    public void sortByBirthDate(Comparator<T> birthDateComparator) {
        members.sort(birthDateComparator);
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
