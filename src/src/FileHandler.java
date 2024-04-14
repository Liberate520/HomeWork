package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHandler {

    // Сериализация в файл с помощью класса ObjectOutputStream
    public static void SavingToFile (FamilyTree fT) throws FileNotFoundException, IOException{
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("FamilyTree.out"));
        objectOutputStream.writeObject(fT);
        objectOutputStream.close();
    }

        // Востановление из файла с помощью класса ObjectInputStream
    public static FamilyTree FileUpload() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTree.out"));
        FamilyTree fTRestored = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return fTRestored;
    }
    
}
