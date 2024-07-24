package familyTree;

// import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Comparator.CompareByAge;
import Comparator.CompareByName;

public class FamilyTree implements Iterable <Human> {
// public class FamilyTree implements Serializable {
    // private static final long serialVersionUID = 1L;
    
    private List<Human> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(Human human) {
        family.add(human);
    }

    public void addMembers(Human... humans) {
        for (Human human : humans) {
            family.add(human);
        }
    }

    public List <Human> getFamily() {
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
        family.sort(new CompareByName());
    }

    public void sortByAge(){
        family.sort(new CompareByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return family.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human person : family) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }
}

