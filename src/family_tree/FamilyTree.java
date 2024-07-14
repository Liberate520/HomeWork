package family_tree;

import human.Human;
import tree_node.TreeNode;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeNode<T>> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private final List<T> members;
    private LocalDate birthDate;
    private LocalDate deathDate;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public void connectSpouses(T person1, T person2) {
        ((Human)person1).setSpouse((Human)person2);
        ((Human)person2).setSpouse((Human)person1);
    }

    public void connectParents(T child, T father, T mother) {
        child.setParent((Human) father);
        child.setParent((Human) mother);
        ((Human)father).addChild((Human)child);
        ((Human)mother).addChild((Human)child);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Tree:\n");

        if (members.isEmpty()) {
            sb.append("Family tree is empty.");
        } else {
            for (T member : this) {
                sb.append("Name: ").append(member.getName());
                sb.append(", Gender: ").append(((Human)member).getGender());
                sb.append(", Age: ").append(((Human)member).getAge());

                if (((Human)member).getSpouse() != null) {
                    sb.append(", Spouse: ").append(((Human)member).getSpouse().getName());
                }

                if (member.getParent() != null) {
                    StringBuilder append = sb.append(", Parent: ").append(member.getParent().getName());
                }

                sb.append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void addMember(Human wika) {
    }

    public void addHumanMember(T wowa) {
    }
}
