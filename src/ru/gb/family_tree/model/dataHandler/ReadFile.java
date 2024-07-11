package ru.gb.family_tree.model.dataHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile implements Readable{
    @Override
    public Object readData(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename+".out"));
        Object new_object = (Object) ois.readObject();
        System.out.println("Чтение данных из " + filename +".out завершено");
        ois.close();
        return new_object;
    }
}
