package homeWork.Writer;

import homeWork.Tree.FamilyTree;
import java.io.*;

public class FileHandler implements Writer {

    @Override
    public void writeToFile(FamilyTree tree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);
        } catch (IOException e) {
            throw new IOException("Ошибка записи в файл: " + e.getMessage());
        }
    }

    @Override
    public FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
}