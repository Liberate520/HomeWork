package model.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writer {
    private static FileHandler fileHandler;

    private FileHandler(){}

    public static FileHandler getFileHandler(){
        if (fileHandler == null){
            fileHandler = new FileHandler();
        }
        return fileHandler;
    }
    
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("familyTree.out"))) {
            objectOutputStream.writeObject(serializable);
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object loading() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("familyTree.out"))){
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

}
