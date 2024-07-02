package family_tree.read_write;

import family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public FamilyTree read(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            return null; // Файл не найден, возвращаем null
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException e) {
            // Обработка IOException
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            // Обработка ClassNotFoundException
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void write(String filename, FamilyTree tree) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
        }
    }
}
