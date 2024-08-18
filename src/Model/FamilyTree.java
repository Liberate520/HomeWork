package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember & Comparable<T>> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Метод для добавления нового члена семьи в дерево
    public void addPerson(T person) {
        members.add(person);
    }

    // Метод для получения человека по ID
    public T getPerson(int id) {
        return members.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Метод для получения списка всех людей в дереве
    public List<T> getAllPeople() {
        return new ArrayList<>(members);
    }

    // Метод для поиска людей по имени и/или фамилии
    public List<T> findByName(String firstName, String lastName) {
        List<T> results = new ArrayList<>();
        for (T person : members) {
            if (person.getFirstName().equalsIgnoreCase(firstName) ||
                    person.getLastName().equalsIgnoreCase(lastName)) {
                results.add(person);
            }
        }
        return results;
    }

    // Метод для установки родителей и обновления родственных связей
    public void setParents(int childId, int motherId, int fatherId) {
        T child = getPerson(childId);
        T mother = getPerson(motherId);
        T father = getPerson(fatherId);

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
        T person = getPerson(personId);
        if (person != null) {
            System.out.println("Дети " + person.getFirstName() + " " + person.getLastName() + ":");
            for (FamilyMember child : person.getChildren()) {
                System.out.println(child);
            }
        }
    }

    // Метод для получения родителей человека
    public void getParents(int personId) {
        T person = getPerson(personId);
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
        Collections.sort(members);
    }

    // Метод для сортировки по дате рождения
    public void sortByBirthDate() {
        members.sort(Comparator.comparing(T::getBirthDate));
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
