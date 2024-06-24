package Model.FamilyTree.FileHandler;

import View.IView;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    @Override
    public void writeObjectToFile(Object obj, String filePath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(obj);
        IView.printAnswer("Древо было сериализованно в файл");
        objectOutputStream.close();
    }

    @Override
    public Object recoverObjectFromFile(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        Object obj = objectInputStream.readObject();
        IView.printAnswer("Древо было десериализованно из файла");
        objectInputStream.close();
        return obj;
    }
}