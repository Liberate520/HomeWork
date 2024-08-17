package familytree;

import person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T findMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<T> getMembers() {
        return members;
    }

    public void sortByName() {
        members.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        members.sort(Comparator.comparing(Person::getBirthDate));
    }

    public void addParentChildRelation(T parent, T child) {
        parent.addChild(child);
        child.addParent(parent);
    }
}
