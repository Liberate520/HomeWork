package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Writer<T extends Human> implements Writeable<T> {
    public void writeToFile(FamilyTree<T> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }

}
