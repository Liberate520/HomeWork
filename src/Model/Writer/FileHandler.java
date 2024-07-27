package Model.Writer;

import Model.FamilyTree.FamilyTreeService.FamilyTreeService;

import java.io.*;

public class FileHandler implements Writable {
    String fileName = "FamilyTree.out";
    private static FileHandler instance;

    public static FileHandler getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance of FileHandler");
            instance = new FileHandler();
        }
        return instance;
    }

    @Override
    public boolean writeObjecttoFile(Object object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return true;
    }

    @Override
    public Object readObjectfromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

        return objectInputStream.readObject();
    }
}
