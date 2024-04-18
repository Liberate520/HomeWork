package Family_Tree.FileHandler;
import java.io.*;

public class Writable implements WriteTo {
    public boolean save(Serializable serializable, String filepath) {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filepath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Objeact read(String filepath) {
        // Чтение файла с помощью класса ObjectInputStream
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filepath))) {
            return ObjectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
