package writer;

import java.io.*;

public class FileHandler implements Writer {
    public static  String treePath = "src/writer/tree.txt";

    @Override
    public   void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream(treePath));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();

    }


    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(treePath));
        Object object = objectInputStream.readObject();
        return object;

    }
}

