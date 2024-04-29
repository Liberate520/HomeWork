package src.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class FileHandler implements Writable {

    // Сериализация в файл с помощью класса ObjectOutputStream
    public  void savingToFile (Serializable serializable, String filePath ) throws FileNotFoundException, IOException{
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

        // Востановление из файла с помощью класса ObjectInputStream
    
    @SuppressWarnings("unchecked")
    public FamilyTree<Person> fileUpload(File filePath) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        FamilyTree<Person> fTRestored = (FamilyTree<Person>) objectInputStream.readObject();
        objectInputStream.close();
        return fTRestored;
    }
}
