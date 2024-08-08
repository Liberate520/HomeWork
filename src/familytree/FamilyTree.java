package familytree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(T person) {
        this.members.add(person);
    }

    public T findPersonByName(String name) {
        for (T member : members) {
            if (member instanceof HasName && ((HasName) member).getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getChildren(T person) {
        if (person instanceof HasRelations) {
            return ((HasRelations<T>) person).getChildren();
        }
        return new ArrayList<>();
    }

    public List<T> getParents(T person) {
        if (person instanceof HasRelations) {
            return ((HasRelations<T>) person).getParents();
        }
        return new ArrayList<>();
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(member -> {
            if (member instanceof HasName) {
                return ((HasName) member).getName();
            }
            return "";
        }));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(member -> {
            if (member instanceof HasBirthDate) {
                return ((HasBirthDate) member).getBirthDate();
            }
            return null;
        }));
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FamilyTree:\n");
        for (T member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}
