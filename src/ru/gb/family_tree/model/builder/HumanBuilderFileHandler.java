package ru.gb.family_tree.model.builder;

import ru.gb.family_tree.model.FT.Writable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HumanBuilderFileHandler implements Writable {

    public void saveHumanBuilder(HumanBuilderInterface humanBuilder, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(humanBuilder);
        }
    }

    public HumanBuilder loadHumanBuilder(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (HumanBuilder) ois.readObject();
        }
    }
}
