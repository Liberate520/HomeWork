import java.io.*;

public class FileHandler implements Writer{

    @Override
    public void save(String fileName, FamilyTree tree) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(tree);
        }
    }

    @Override
    public FamilyTree load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) objectInputStream.readObject();
        }
    }
}
