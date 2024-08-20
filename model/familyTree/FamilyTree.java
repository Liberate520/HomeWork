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
}