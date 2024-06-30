package family_tree.read_write;

import family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    @Override
    public FamilyTree read(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            // Создаем новое дерево, если файл не существует
            FamilyTree tree = new FamilyTree();
            write(filename, tree); // Записываем новое дерево в файл
            return tree;
        }

        objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }

    @Override
    public void write(String filename, FamilyTree tree) throws IOException {
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }
}
