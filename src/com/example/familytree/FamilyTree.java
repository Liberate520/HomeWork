package com.example.familytree;

import com.example.familytree.model.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Класс FamilyTree представляет генеалогическое древо и реализует Serializable и Iterable<T>
public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;

    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Добавление объекта в генеалогическое древо
    public void addPerson(T person) {
        this.members.add(person);
    }

    // Получение всех объектов в генеалогическом древе
    public List<T> getAllMembers() {
        return members;
    }

    // Поиск человека по имени
    public T findPersonByName(String name) {
        for (T person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    // Получение всех детей выбранного человека
    public List<T> getChildrenOf(String name) {
        T person = findPersonByName(name);
        if (person != null) {
            return (List<T>) person.getChildren();
        }
        return new ArrayList<>();
    }

    // Демонстрация всех членов дерева
    public void displayTree() {
        for (T person : members) {
            System.out.println(person);
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
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
