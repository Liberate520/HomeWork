package family_tree;

import java.io.*;

// Класс для работы с файлами
public class FileHandler {

    // Метод для сохранения семейного дерева в файл
    public void saveFamilyTree(FamilyTree familyTree, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
            System.out.println("Семейное дерево успешно сохранено в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки семейного дерева из файла
    public FamilyTree loadFamilyTree(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTree familyTree = (FamilyTree) ois.readObject();
            System.out.println("Семейное дерево успешно загружено из файла " + fileName);
            return familyTree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

