package Writer;

import java.io.*;

public class FileHandler implements Writable{
    private String filePath = "src/writer.txt";

    @Override
    public boolean writeToFileObject(Serializable object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return true;
    }

    @Override
    public Object readObjectInFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        Object object = objectInputStream.readObject();
        objectInputStream.close();

        return object;
    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}
