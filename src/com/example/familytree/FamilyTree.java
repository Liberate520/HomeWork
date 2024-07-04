package com.example.familytree;

import com.example.familytree.model.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Класс FamilyTree представляет генеалогическое древо и реализует Serializable и Iterable<Person>
public class FamilyTree implements Serializable, Iterable<Person> {
    private static final long serialVersionUID = 1L;

    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Добавление человека в генеалогическое древо
    public void addPerson(Person person) {
        this.members.add(person);
    }

    // Получение всех детей выбранного человека
    public List<Person> getChildrenOf(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person.getChildren();
            }
        }
        return new ArrayList<>();
    }

    // Получение всех людей в генеалогическом древе
    public List<Person> getAllMembers() {
        return members;
    }

    // Поиск человека по имени
    public Person findPersonByName(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    // Демонстрация всех членов дерева и их детей
    public void displayTree() {
        for (Person person : members) {
            System.out.println(person);
            List<Person> children = person.getChildren();
            if (!children.isEmpty()) {
                System.out.println("  Дети: " + children);
            }
        }
    }

    // Сортировка членов дерева по имени
    public void sortByName() {
        Collections.sort(members, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    // Сортировка членов дерева по дате рождения
    public void sortByBirthDate() {
        Collections.sort(members, (p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()));
    }

    @Override
    public Iterator<Person> iterator() {
        return members.iterator();
    }
}
