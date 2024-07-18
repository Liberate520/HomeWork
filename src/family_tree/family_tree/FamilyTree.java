package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
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

    public List<Human> getMembers() {
        return members;
    }

    @Override
    public Iterator<Human> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, new HumanNameComparator());
    }

    public void sortByChildrenCount() {
        Collections.sort(members, new HumanChildrenCountComparator());
    }
}
