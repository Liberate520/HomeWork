package ru.gb.family_tree.model.dataHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteFile implements Writeble {
    @Override
    public void writeData(Object object, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename+".out"));
        oos.writeObject(object);
        System.out.println("Запись данных в " + filename +".out завершена");
        oos.close();
    }
}
