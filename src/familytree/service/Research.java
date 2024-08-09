package familytree.service;

import familytree.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Research {
    public static List<Person> findChildren(Person person) {
        return person.getChildren();
    }
}