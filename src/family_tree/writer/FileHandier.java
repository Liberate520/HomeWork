package family_tree.writer;

import java.io.*;

public class FileHandier implements Writer {
    public void Save(Serializable ft, String way) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(way))) {
            objectOutputStream.writeObject(ft);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось сохранить FamilyTree в файл: " + way, e);
        }
    }

    public Object Input(String way) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(way))) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
