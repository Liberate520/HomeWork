import java.io.*;

public class FileHandler implements Writable {

    private ByteArrayOutputStream byteArrayOutputStream;

    @Override
    public void writeObjectToFile(Object obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("obj.out"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public Object recoverObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("obj.out"));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

    @Override
    public void serializeObjectToByteArray(Object obj) throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Override
    public Object recoverObjectFromByteArray() throws IOException, ClassNotFoundException {
        if (byteArrayOutputStream == null) {
            throw new IOException("Выходной поток массива байтов не инициализирован");
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
}
