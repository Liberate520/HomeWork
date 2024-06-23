package family_tree.handler;

import family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable{
    @Override
    public void writeClass(FamilyTree familyTree) throws IOException {   //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree readClass() throws IOException, ClassNotFoundException {   // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        FamilyTree familyTreeRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTreeRestored;
    }
}
