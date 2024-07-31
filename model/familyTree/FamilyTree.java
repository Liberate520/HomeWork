package model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Comparator.CompareByAge;
import model.Comparator.CompareByName;

public class FamilyTree<E extends FamilyTreeMember<E>> implements Iterable <E>, Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<E> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(E member) {
        family.add(member);
    }

    public void addMembers(E member1, E member2) {
        family.add(member1); family.add(member2);

    }

    public List <E> getFamily() {
        return family;
    }

    public void sortByName(){
        family.sort(new CompareByName<>());
    }

    public void sortByAge(){
        family.sort(new CompareByAge<>());
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

