package model.writer;


import java.io.*;

public class FileHandler implements Writer {
    // Метод для сохранения объекта в файл
    @Override
    public void save(Serializable serializable) {
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PathToFile.getDefaultPath()))) {
            // Записываем объект в файл
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения объекта из файла
    @Override
    public Object read() {
        Object readedObject;
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PathToFile.getDefaultPath()))) {
            // Читаем объект из файла
            readedObject = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return readedObject;
    }

    // Метод для установки пути к файлу
    @Override
    public void setPath(String path) {
        PathToFile.setPath(path);
    }

    @Override
    public String getPath() {
        return PathToFile.getDefaultPath();
    }
}
