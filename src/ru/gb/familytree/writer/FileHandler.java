package ru.gb.familytree.writer;

import ru.gb.familytree.human.HumanInfo;

import java.io.*;
import java.util.List;

public class FileHandler implements Writer {

    @Override
    public void save(List<HumanInfo> people, String path) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(people);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public List<HumanInfo> load(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (List<HumanInfo>) in.readObject();
        }
    }
}