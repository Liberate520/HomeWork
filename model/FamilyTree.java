package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T person) {
        members.add(person);
    }

    public T getMemberById(int id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}
