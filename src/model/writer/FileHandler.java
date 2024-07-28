package model.writer;


import java.io.*;

public class FileHandler implements Writer {
    // Поле для хранения пути к файлу
    private String filePath = "src/model/writer/testFiles/tree.out";
    private final String ERROR_READ = "Ошибка выгрузки из файла.";

    // Метод для сохранения объекта в файл
    @Override
    public void save(Serializable serializable) {
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // Записываем объект в файл
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения объекта из файла
    @Override
    public Object read() {
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            // Читаем объект из файла
            return objectInputStream.readObject();
        } catch (Exception e) {
            return ERROR_READ;
        }
    }

    // Метод для установки пути к файлу
    @Override
    public void setPath(String path) {
        filePath = path;
    }

    @Override
    public String getPath() {
        return filePath;
    }
}
