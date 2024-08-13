package lv.homeWork.model;

import java.io.*;

public class FileHandler implements Writable {


    @Override
    public boolean save(Serializable serializable, String pathToFile) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public Object read(String pathToFile) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFile))){
            return objectInputStream.readObject();


        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
            }
}
