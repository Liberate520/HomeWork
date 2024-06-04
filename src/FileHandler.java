import java.io.*;

public class FileHandler implements Writable {

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
    public void serializeObjectToByteArray(Object obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // Локальная переменная
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();

        // Восстановление объекта для проверки
        recoverObjectFromByteArray(byteArrayOutputStream.toByteArray());
    }

    public Object recoverObjectFromByteArray(byte[] byteArray) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArray));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
}