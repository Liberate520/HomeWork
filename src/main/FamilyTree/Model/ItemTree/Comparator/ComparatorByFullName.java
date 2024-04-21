package FamilyTree.Model.ItemTree.Comparator;


import FamilyTree.Model.ItemTree.Person;

import java.util.Comparator;

public class ComparatorByFullName implements Comparator<Person> {
    @Override
    public int compare(Person t0, Person t1) {
        if (t0.getFirstName().compareTo(t1.getFirstName()) == 0) {
            return t0.getLastName().compareTo(t1.getLastName());
        }

        return t0.getFirstName().compareTo(t1.getFirstName());
    }
}
