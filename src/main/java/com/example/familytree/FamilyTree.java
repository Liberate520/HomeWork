package com.example.familytree;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Person> people;

    public FamilyTree() {
        people = new HashMap<>();
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
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveToFile(filename, this);
    }

    public static FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.loadFromFile(filename);
    }
}
