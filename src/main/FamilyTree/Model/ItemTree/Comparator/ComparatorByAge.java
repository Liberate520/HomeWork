package FamilyTree.Model.ItemTree.Comparator;


import FamilyTree.Model.ItemTree.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person t0, Person t1) {
        return t0.getBirtDay().compareTo(t1.getBirtDay());

    }


}
