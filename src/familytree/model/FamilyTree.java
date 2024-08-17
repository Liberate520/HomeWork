package familytree.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Comparator;
import java.util.Iterator;

public class FamilyTree<T extends Identifiable> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private Map<FullName, T> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(T member) {
        members.put(member.getFullName(), member);
    }

    public T findMemberByFullName(String familyName, String firstName, String fatherName) {
        return members.get(new FullName(familyName, firstName, fatherName));
    }

    public List<T> findChildrenByFullName(String familyName, String firstName, String fatherName) {
        T member = findMemberByFullName(familyName, firstName, fatherName);
        if (member != null) {
            return member.getChildren();
        }
        return new ArrayList<>();
    }

    public void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                           String childFamilyName, String childFirstName, String childFatherName) {
        T parent = findMemberByFullName(parentFamilyName, parentFirstName, parentFatherName);
        T child = findMemberByFullName(childFamilyName, childFirstName, childFatherName);
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return members.values().iterator();
    }

    public List<T> getSortedByName() {
        List<T> sortedList = new ArrayList<>(members.values());
        sortedList.sort(Comparator.comparing(m -> m.getFullName().getFirstName()));
        return sortedList;
    }

    public List<T> getSortedByDateOfBirth() {
        List<T> sortedList = new ArrayList<>(members.values());
        sortedList.sort(Comparator.comparing(T::getDateOfBirth));
        return sortedList;
    }
}