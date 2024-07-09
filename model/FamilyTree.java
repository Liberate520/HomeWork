package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public void sortByName(java.util.function.Function<T, String> nameExtractor) {
        Collections.sort(members, (m1, m2) -> nameExtractor.apply(m1).compareTo(nameExtractor.apply(m2)));
    }

    public void sortByBirthDate(java.util.function.Function<T, Comparable> birthDateExtractor) {
        Collections.sort(members, (m1, m2) -> birthDateExtractor.apply(m1).compareTo(birthDateExtractor.apply(m2)));
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
