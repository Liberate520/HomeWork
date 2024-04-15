package homeWork;

import java.io.*;

public class FileHandler {
    public static void serializeToFile(FamilyTree tree, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(tree);
            System.out.println("Дерево семьи сохранено в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении дерева семьи в файл " + filename + ": " + e.getMessage());
        }
    }

    public static FamilyTree deserializeFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            FamilyTree tree = (FamilyTree) inputStream.readObject();
            System.out.println("Дерево семьи загружено из файла " + filename);
            return tree;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке дерева семьи из файла " + filename + ": " + e.getMessage());
            return null;
        }
    }
}
