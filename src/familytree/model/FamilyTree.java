package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeMember> implements Iterable<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(TreeMember::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(TreeMember::getBirthDate));
    }
}