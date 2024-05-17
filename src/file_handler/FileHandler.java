package file_handler;

import family_tree.FamilyTree;
import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void saveTree(FamilyTree familyTree) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("D:\\Запаско\\Обучение в ИТ\\Программирование\\ООП\\family_tree.FamilyTree\\SavedTree.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();

        System.out.println("Успешно сохранено");
    }

    public FamilyTree downloadTree() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Запаско\\Обучение в ИТ\\Программирование\\ООП\\family_tree.FamilyTree\\SavedTree.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Успешно загружено");
        return familyTree;
    }
}
