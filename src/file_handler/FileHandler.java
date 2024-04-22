package file_handler;

import family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void saveTree(FamilyTree familyTree) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\masle\\OneDrive\\Desktop\\Katherine\\GeekBrains\\Объектно-ориентированное программирование (Java)\\family_tree.FamilyTree\\SavedTree.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();

        System.out.println("Сохранено!");
    }

    public FamilyTree downloadTree() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\masle\\OneDrive\\Desktop\\Katherine\\GeekBrains\\Объектно-ориентированное программирование (Java)\\family_tree.FamilyTree\\SavedTree.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        
        System.out.println("Загружено!");
        return familyTree;
    }
}
