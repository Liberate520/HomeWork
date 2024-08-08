package F_tree;

import java.io.*;

public class FileHandler implements Writer {
    @Override
    public void save(FamilyTree familyTree, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
            System.out.println("Семейное древо успешно сохранено в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении семейного древа: " + e.getMessage());
        }
    }

    @Override
    public FamilyTree load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTree loadedTree = (FamilyTree) ois.readObject();
            System.out.println("Семейное древо успешно загружено из файла: " + fileName);
            return loadedTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке семейного древа: " + e.getMessage());
            return null;
        }
    }
}