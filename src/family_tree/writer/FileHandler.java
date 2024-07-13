package family_tree.writer;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath ="src/family_tree/writer/tree.txt";
    //метод сохранения
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод загрузки
    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath))){
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String filePath){
        this.filePath = filePath;
    }

}

