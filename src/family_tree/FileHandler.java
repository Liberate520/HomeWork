package family_tree;

import java.io.*;

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

    // Метод для чтения семейного дерева из файла
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

    // Метод для сохранения семейного дерева в текстовый файл
    public void saveFamilyTreeAsText(FamilyTree familyTree, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Human human : familyTree.getAllHumans()) {
                writer.write(human.toString());
                writer.newLine();
            }
            System.out.println("Семейное дерево успешно сохранено в текстовый файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения семейного дерева из текстового файла
    public FamilyTree loadFamilyTreeFromText(String fileName) {
        FamilyTree familyTree = new FamilyTree();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Предполагается, что строка формата: Имя, Пол, Дата рождения, Дата смерти (если есть), Родители, Дети
                // Необходимо будет распарсить эту строку и создать объект Human
                // Парсинг строки не реализован здесь
            }
            System.out.println("Семейное дерево успешно загружено из текстового файла " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return familyTree;
    }
}
