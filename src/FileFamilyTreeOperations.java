import java.io.*;

// Класс для операций с файлами, реализующий интерфейс FileOperations
class FileFamilyTreeOperations implements FileOperations {

    @Override
    public void saveToFile(String filename, FamilyTree tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tree);
            System.out.println("Дерево сохранено в файл: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree loadFromFile(String filename) {
        FamilyTree tree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tree = (FamilyTree) ois.readObject();
            System.out.println("Дерево загружено из файла: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
