package service;

import person.Person;
import java.util.Comparator;
import java.util.List;

public class TreeSorter<T extends Person> {

    public void sortByName(List<T> members) {
        members.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate(List<T> members) {
        members.sort(Comparator.comparing(Person::getBirthDate));
    }
}
