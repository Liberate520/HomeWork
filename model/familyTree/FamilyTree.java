package model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeMember<E>> implements Iterable<E>, Serializable {
    private List<E> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(E member) {
        family.add(member);
    }

    public void sort(Comparator<E> comparator) {
        family.sort(comparator);
    }

    @Override
    public Iterator<E> iterator() {
        return family.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E person : family) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }

    public E findById(String id) {
        for (E member : family) {
            if (member instanceof Human && ((Human) member).getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public void createFamilyLink(String childId, String parentId) {
        E child = findById(childId);
        E parent = findById(parentId);
        if (child != null && parent != null) {
            child.addParent(parent);
            if (parent instanceof Human) {
                ((Human) parent).addChild((Human) child);
            }
        }
    }
}
