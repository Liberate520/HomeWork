package ru.gb.familytree.writer;

import ru.gb.familytree.familytree.FamilyMember;

import java.io.*;
import java.util.List;

public class FileHandler {
    public <T extends FamilyMember> void save(List<T> members, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(members);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends FamilyMember> List<T> load(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        }
    }
}