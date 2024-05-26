package homeWork;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Long, Person> persons;

    public FamilyTree() {
        this.persons = new HashMap<>();
    }

    public void addPerson(Person person) {
        persons.put(person.getId(), person);
        for (Long parentId : person.getParentIds()) {
            Person parent = persons.get(parentId);
            if (parent != null) {
                parent.addChildId(person.getId());
            }
        }
        for (Long childId : person.getChildIds()) {
            Person child = persons.get(childId);
            if (child != null) {
                child.addParentId(person.getId());
            }
        }
    }

    public void displayFamilyInfo(Long personId, List<Person> allPersons) {
        Person person = findPersonById(personId);
        if (person != null) {
            System.out.println("Информация о персоне: " + person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName());
            displayParentInfo(person, allPersons, 0);
            displayChildrenInfo(person, allPersons, 0);
        } else {
            System.out.println("Персона с id " + personId + " не найдена.");
        }
    }

    private void displayParentInfo(Person person, List<Person> allPersons, int level) {
        for (Long parentId : person.getParentIds()) {
            Person parent = findPersonById(parentId);
            if (parent != null && allPersons.contains(parent)) {
                printIndented("Родитель: " + parent.getLastName() + " " + parent.getFirstName() + " " + parent.getMiddleName(), level);
                displayParentInfo(parent, allPersons, level + 1);
            }
        }
    }

    private void displayChildrenInfo(Person person, List<Person> allPersons, int level) {
        for (Long childId : person.getChildIds()) {
            Person child = findPersonById(childId);
