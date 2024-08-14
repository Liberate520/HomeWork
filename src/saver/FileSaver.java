package saver;

import java.io.*;

public class FileSaver implements Saver{
    private String filePath;

    @Override
    public boolean save(Serializable serializable) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object restore() {
        Object tree = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            tree = objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;

    }
}
