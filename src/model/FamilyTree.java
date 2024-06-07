package model;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T person) {
        this.members.add(person);
    }

    public List<Person> getChildrenOf(Person parent) {
        if (parent instanceof Person) {
            return ((Person) parent).getChildren();
        }
        return new ArrayList<>();
    }

    public T findPersonByName(String name) {
        for (T person : members) {
            if (person instanceof Person && ((Person) person).getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<T> getMembers() {
        return members;
    }

    public void setMembers(List<T> members) {
        this.members = members;
    }
}

