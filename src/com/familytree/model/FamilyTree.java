package com.familytree.model;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private long idCounter;
    private final List<T> members;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> members) {
        this.members = members;
    }

    public boolean add(T member) {
        if (member == null) {
            return false;
        }
        if (!members.contains(member)) {
            members.add(member);
            member.setId(idCounter++);
            addToParents(member);
            addToChildren(member);
        }
        return true;
    }

    private void addToParents(T member) {
        for (Human parent : member.getParents()) {
            parent.addChild(member);
        }
    }

    private void addToChildren(T member) {
        for (Human child : member.getChildren()) {
            child.addParent(member);
        }
    }

    public void setWedding(long id1, long id2) {
        if (checkId(id1) && checkId(id2)) {
            T human1 = getById(id1);
            T human2 = getById(id2);
            if (human1 != null && human2 != null){
                if (human1.getSpouse() == null && human2.getSpouse() == null) {
                    human1.setSpouse(human2);
                    human2.setSpouse(human1);

                }
            }
        }
    }

    private boolean checkId(long id) {
        return id < idCounter && id >= 0;
    }

    public T getById(long id) {
        for (T member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public void sortByName(){
        members.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        members.sort(Comparator.comparing(Human::getBirthDate));
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }



    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            sb.append("В дереве ");
            sb.append(members.size());
            sb.append(" объектов: \n");
            for (Human human : members) {
                sb.append(human);
                sb.append("\n");
            }
        } else {
            sb.append("Дерево пустое или не инициализировано.");
        }
        return sb.toString();
    }
}

