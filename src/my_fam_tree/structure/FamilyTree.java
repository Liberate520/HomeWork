package my_fam_tree.structure;


import java.io.Serializable;
import java.util.*;


public class FamilyTree implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addHuman(Human human) {
        people.add(human);
    }

    public List<Human> getPeople() {
        return people;
    }

    public Human findHuman(String name) {
        for (Human human : people) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
    public void sortName() {
        Collections.sort(people, comparator1);
    }

    private Comparator<Human> comparator1 = Comparator.comparing(Human:: getName);

    public void sortBirthDate(){
        Collections.sort(people, comparator2);
    }

    private Comparator<Human> comparator2 = Comparator.comparing(Human :: getDateOfBirth);

    @Override
    public Iterator<Human> iterator() {
        return people.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : people) {
            sb.append(human).append("\n");
    }
    return sb.toString();
}
}

