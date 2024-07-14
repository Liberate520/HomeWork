package family_tree.writer;

import family_tree.family.FamilyTree;

import java.io.*;

public class FileHandier implements Writer {
    public void Save(FamilyTree ft, String way) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(way))) {
            objectOutputStream.writeObject(ft);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось сохранить FamilyTree в файл: " + way, e);
        }
    }

    public FamilyTree Input(String way) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(way))) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
