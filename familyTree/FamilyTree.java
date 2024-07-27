package familyTree;

// import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Comparator.CompareByAge;
import Comparator.CompareByName;

public class FamilyTree<E extends FamilyTreeMember> implements Iterable <E> {
// public class FamilyTree implements Serializable {
    // private static final long serialVersionUID = 1L;
    
    private List<E> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(E human) {
        family.add(human);
    }

    public void addMembers(E... humans) {
        for (E human : humans) {
            family.add(human);
        }
    }

    public List <E> getFamily() {
        return family;
    }

    public List<Human> getAncestors(Human person, int generations) {
        List<Human> ancestors = new ArrayList<>();
        getAncestorsRecursive(person, generations, ancestors);
        return ancestors;
    }

    private void getAncestorsRecursive(Human person, int generations, List<Human> ancestors) {
        if (generations == 0 || person == null) return;
        if (!person.parents.isEmpty()) {
            ancestors.addAll(person.parents);
            for (Human parent : person.parents) {
                getAncestorsRecursive(parent, generations - 1, ancestors);
            }
        }
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

