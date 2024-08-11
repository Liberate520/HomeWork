package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    // Метод для добавления нового члена семьи в дерево
    public void addPerson(Person person) {
        people.add(person);
    }

    // Метод для получения человека по ID
    public Person getPerson(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Метод для получения списка всех людей в дереве
    public List<Person> getAllPeople() {
        return new ArrayList<>(people);
    }

    // Метод для поиска людей по имени и/или фамилии
    public List<Person> findByName(String firstName, String lastName) {
        List<Person> results = new ArrayList<>();
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(firstName) ||
                    person.getLastName().equalsIgnoreCase(lastName)) {
                results.add(person);
            }
        }
        return results;
    }

    // Метод для установки родителей и обновления родственных связей
    public void setParents(int childId, int motherId, int fatherId) {
        Person child = getPerson(childId);
        Person mother = getPerson(motherId);
        Person father = getPerson(fatherId);

        if (child != null) {
            child.setMother(mother);
            child.setFather(father);
            if (mother != null) {
                mother.addChild(child);
            }
            if (father != null) {
                father.addChild(child);
            }
        }
    }

    // Метод для получения детей человека
    public void getChildren(int personId) {
        Person person = getPerson(personId);
        if (person != null) {
            System.out.println("Дети " + person.getFirstName() + " " + person.getLastName() + ":");
            for (Person child : person.getChildren()) {
                System.out.println(child);
            }
        }
    }

    // Метод для получения родителей человека
    public void getParents(int personId) {
        Person person = getPerson(personId);
        if (person != null) {
            System.out.println("Родители " + person.getFirstName() + " " + person.getLastName() + ":");
            if (person.getMother() != null) {
                System.out.println("Мать: " + person.getMother());
            } else {
                System.out.println("Мать: не указано");
            }
            if (person.getFather() != null) {
                System.out.println("Отец: " + person.getFather());
            } else {
                System.out.println("Отец: не указано");
            }
        }
    }
    // Метод для сортировки по умолчанию (по имени)
    public void sort() {
        Collections.sort(people);
    }

    // Метод для сортировки по дате рождения
    public void sortByBirthDate() {
        people.sort(Comparator.comparing(Person::getBirthDate));
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
