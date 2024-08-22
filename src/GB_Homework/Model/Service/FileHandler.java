package GB_Homework.Model.Service;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath = "src/GB_Homework/Model/Saved_Tree/familyTree.txt";

    // Метод выбора пути к файлу
    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Метод сохранения
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод загрузки
    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}