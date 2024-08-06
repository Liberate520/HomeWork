package FamilyTree.utility;

import FamilyTree.model.FamilyTree;
import FamilyTree.model.ItemFamilyTree;

import java.io.*;

public class FileHandler<T extends ItemFamilyTree> implements Writer {

    private String filePath = "src/FamilyTree/utility/family_tree.dat";

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public FamilyTree load() {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            System.err.println("Файл не существует или недоступен для чтения: " + filePath);
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}