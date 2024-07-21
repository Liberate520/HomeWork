package ru.gb.familytree.writer;

import ru.gb.familytree.model.HumanInfo;

import java.io.*;
import java.util.List;

public class FileHandler {
    public void save(List<HumanInfo> members, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(members);
        }
    }

    @SuppressWarnings("unchecked")
    public List<HumanInfo> load(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<HumanInfo>) ois.readObject();
        }
    }
}