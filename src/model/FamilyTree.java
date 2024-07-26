package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T getMember(String name) {
        for (T member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getMembers() {
        List<T> members1 = this.members;
        return members1;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
