package familytree.service;

import familytree.model.Person;
import java.util.List;

public interface FamilyTreeService {
    void addPerson(Person person);
    List<Person> getAllPeople();
    List<Person> findChildren(String name);
    void sortByName();
    void sortByBirthDate();
    void saveToFile(String fileName) throws Exception;
    void loadFromFile(String fileName) throws Exception;
}