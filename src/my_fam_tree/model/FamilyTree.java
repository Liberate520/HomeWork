package my_fam_tree.model;


import java.io.Serializable;
import java.util.*;


public class FamilyTree <T extends InFamily<T>> implements FamTreeOper<T>, Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> relatives;

    public FamilyTree() {
        this.relatives = new ArrayList<>();
    }
    @Override
    public void addRelative(T relative) {
        relatives.add(relative);
    }

    @Override
    public List<T> getRelatives() {
        return relatives;
    }

    @Override
    public T findHuman(String name) {
        for (T relative : relatives) {
            if (relative.getName().equals(name)) {
                return relative;
            }
        }
        return null;
    }

    @Override
    public void sortName() {
        relatives.sort(Comparator.comparing(InFamily::getName));
    }

    @Override
    public void sortBirthDate() {
        relatives.sort(Comparator.comparing(InFamily::getDateOfBirth));
    }


    @Override
    public Iterator<T> iterator() {
        return relatives.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T relative : relatives) {
            sb.append(relative).append("\n");
        }
        return sb.toString();
    }
}

