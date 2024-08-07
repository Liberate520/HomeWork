package Homework2_OOP;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public boolean save(Serializable serializable){
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("save.txt"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object read() {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("save.txt"));
        return objectInputStream.readObject();
    }
}
