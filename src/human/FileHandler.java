package human;

import writer.Writable;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close(); //идет автоматическое закрытие с помощью try
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject(); //readObject всегда возвращает объект
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
