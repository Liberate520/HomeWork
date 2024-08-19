package FamilyTree.model.utility;

import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.familyTree.ItemFamilyTree;

import java.io.*;

public class FileHandler<T extends ItemFamilyTree> implements Writer {

    private String filePath = "src/FamilyTree/model/utility/family_tree.dat";

    @Override
    public void save(Serializable serializable) {
        System.out.println("Попытка сохранить объект в файл: " + filePath);
        File file = new File(filePath);
        try {
            // Создание родительских каталогов, если они не существуют
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(serializable);
                System.out.println("Файл успешно сохранен: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    public FamilyTree load() {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            System.err.println("Файл не существует или недоступен для чтения: " + filePath);
            return new FamilyTree<>(); // Возвращаем пустое дерево, если файл не существует
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new FamilyTree<>(); // Возвращаем пустое дерево при ошибке
    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}