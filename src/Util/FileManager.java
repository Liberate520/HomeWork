package Util;

import Model.FamilyTree;
import Model.Person;

import java.io.*;

public class FileManager implements DataHandler<FamilyTree<Person>> {

    @Override
    public void saveFamilyTree(FamilyTree<Person> familyTree, String saveFilename) {
        if (!saveFilename.endsWith(".ser")) {
            saveFilename += ".ser";
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFilename))) {
            oos.writeObject(familyTree);
            System.out.println("Дерево сохранено в файл: " + saveFilename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    @Override
    public FamilyTree<Person> loadFamilyTree(String saveFilename) {
        if (!saveFilename.endsWith(".ser")) {
            saveFilename += ".ser";
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFilename))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
            return null;
        }
    }
}
