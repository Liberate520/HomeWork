package com.example.familytree;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private Map<String, Person> people;
    private FileHandler fileHandler;

    public FamilyTree() {
        people = new HashMap<>();
        fileHandler = new FileHandler(people);
    }

    public void addPerson(String name, Date birthDate, String gender, Person mother, Person father) {
        people.put(name, new Person(name, birthDate, gender, mother, father));
    }

    public void addChild(String parentName, String childName, Date birthDate, String gender) {
        Person parent = people.get(parentName);
        Person child = new Person(childName, birthDate, gender, null, parent);
        if (parent != null) {
            parent.addChild(child);
            people.put(childName, child);
        }
    }

    public Person getPerson(String name) {
        return people.get(name);
    }

    public String getFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (Person person : people.values()) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }

    public void saveToFile(String filename) throws IOException {
        fileHandler.saveToFile(filename);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        fileHandler.loadFromFile(filename);
        // Обновим ссылки на людей в дереве после загрузки
        for (Person person : people.values()) {
            if (person.getMother() != null) {
                person.setMother(people.get(person.getMother().getName()));
            }
            if (person.getFather() != null) {
                person.setFather(people.get(person.getFather().getName()));
            }
        }
    }
}
