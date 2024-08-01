package com.example.familytree;

import java.io.*;
import java.util.Map;

public class FileHandler implements FileOperations {
    private Map<String, Person> people;

    public FileHandler(Map<String, Person> people) {
        this.people = people;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
        }
    }

    @Override
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            people = (Map<String, Person>) ois.readObject();
        }
    }
}
