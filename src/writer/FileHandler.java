package writer;

import java.io.*;

public class FileHandler implements Writable{
    public boolean save(Serializable serializable, String fileName){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            return false;
        }

    }

    @Override
    public Object load(String fileName) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
