package ru.gb.familytree.familytree;

import ru.gb.familytree.human.HumanInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
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

    public void sortBy(Comparator<T> comparator) {
        Collections.sort(members, comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}