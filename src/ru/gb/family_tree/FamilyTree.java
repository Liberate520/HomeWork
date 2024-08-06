package ru.gb.family_tree;

import java.io.Serializable;
import java.util.*;

import ru.gb.family_tree.interfaces.HasRelations;

public class FamilyTree<T extends HasRelations<T> & Serializable> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;

    private Map<Integer, T> members;
    private int nextId;

    public FamilyTree() {
        this.members = new HashMap<>();
        this.nextId = 1;
    }

    public void addMember(T member) {
        members.put(nextId++, member);
    }

    public T getMember(int id) {
        return members.get(id);
    }

    public List<T> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public List<T> sortBy(Comparator<T> comparator) {
        List<T> sortedList = new ArrayList<>(members.values());
        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public Iterator<T> iterator() {
        return members.values().iterator();
    }
}
