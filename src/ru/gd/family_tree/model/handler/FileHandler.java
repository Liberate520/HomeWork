package ru.gd.family_tree.model.handler;

import java.io.*;

public class FileHandler implements Writable{
    @Override
    public void save(Serializable serializable, String nameFile) throws IOException {   //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(nameFile));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object read(String nameFile) throws IOException, ClassNotFoundException {   // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(nameFile));
        return objectInputStream.readObject();
    }
}
