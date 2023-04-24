package person.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByIdASC<E extends Person> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getID(), o2.getID());
    }
}
