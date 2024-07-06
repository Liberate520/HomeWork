package ru.gb.family_tree.model.dataHandler;

import java.io.*;

public class FileHandler implements Writeble {

    @Override
    public void writeData(Object object, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename+".out"));
        oos.writeObject(object);
        System.out.println("Запись данных в " + filename +".out завершена");
        oos.close();
    }

    @Override
    public Object readData(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename+".out"));
        Object new_object = (Object) ois.readObject();
        System.out.println("Чтение данных из " + filename +".out завершено");
        ois.close();
        return new_object;
    }
}
