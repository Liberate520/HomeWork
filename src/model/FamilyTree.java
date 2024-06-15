package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T person) {
        this.members.add(person);
    }

    public List<Person> getChildrenOf(Person parent) {
        return parent.getChildren();
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

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}









