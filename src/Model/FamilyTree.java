package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T findMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getParentsOf(String name) {
        T member = findMemberByName(name);
        if (member != null) {
            return (List<T>) member.getParents();
        }
        return null;
    }

    public List<T> getChildrenOf(String name) {
        T member = findMemberByName(name);
        if (member != null) {
            return (List<T>) member.getChildren();
        }
        return null;
    }

    public List<T> getAllMembers() {
        return members;
    }

    public void sortByName() {
        Collections.sort(members, new FamilyMemberComparatorByName<>());
    }

    public void sortByBirthDate() {
        Collections.sort(members, new FamilyMemberComparatorByBirthDate<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyMemberIterator<>(members);
    }
}
