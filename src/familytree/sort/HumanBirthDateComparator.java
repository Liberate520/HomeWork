package familytree.sort;

import familytree.model.Human;

import java.util.Comparator;

public class HumanBirthDateComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}