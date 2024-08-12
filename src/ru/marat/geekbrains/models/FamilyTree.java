package ru.marat.geekbrains.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getChildren(T parent) {
        List<T> children = new ArrayList<>();
        for (Person child : parent.getChildren()) {
            children.add((T) child);  // Приведение типа
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
