package family_tree.model;

import java.io.*;

public class TextTreeReaderWriter implements TreePersistenceService {

    @Override
    public void saveTreeToFile(FamilyTreeModel model, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(model);
            System.out.println("Дерево сохранено в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении дерева в файл " + fileName);
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTreeModel loadTreeFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTreeModel model = (FamilyTreeModel) inputStream.readObject();
            System.out.println("Дерево загружено из файла " + fileName);
            return model;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке дерева из файла " + fileName);
            e.printStackTrace();
            return null;
        }
    }
}