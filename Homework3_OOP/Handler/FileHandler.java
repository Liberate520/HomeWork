package Homework2_OOP;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public boolean save(Serializable serializable){
        
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("save.txt"))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
            
    }

    @Override
    public Object read() {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("save.txt"))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
