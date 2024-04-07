package FamilyTree.Comparator;

import FamilyTree.Human;

import java.util.Comparator;

public class ComparatorByFullName implements Comparator<Human> {
    @Override
    public int compare(Human human, Human t1) {
        if (human.getFirstName().compareTo(t1.getFirstName()) == 0) {
            return human.getLastName().compareTo(t1.getLastName());
        }

        return human.getFirstName().compareTo(t1.getFirstName());
    }
}
