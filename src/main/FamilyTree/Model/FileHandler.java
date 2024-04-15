package FamilyTree.Model;

import FamilyTree.Model.Tree.FamilyTree;
import FamilyTree.Model.Tree.Writable;

import java.io.*;


public class FileHandler implements Writable {
    @Override
    public void save(FamilyTree tree, File fileName) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);

        } catch (IOException ex) {
            System.out.println("Не удалось сохранить данные в архив. Ошибка: " + ex.getMessage());
        }
    }

    @Override
    public FamilyTree read(File fileName) {
        FamilyTree tree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tree = (FamilyTree) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Не удалось восстановить данные из архива. Ошибка: " + ex.getMessage());
        }
        return tree;

    }
}
