package ru.gb.family_tree.writer;

import java.io.*;

/**
 * Класс для работы с файлами, реализующий интерфейс Writable.
 * Позволяет записывать и считывать объекты в/из файлов.
 */
public class FileHandler implements Writable {

    /**
     * Записывает объект, реализующий интерфейс Serializable, в файл по указанному пути.
     *
     * @param serializable объект, который будет записан в файл
     * @param path путь к файлу, в который будет записан объект
     * @return true, если запись прошла успешно, иначе false
     */
    @Override
    public boolean write(Serializable serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Считывает объект из файла по указанному пути.
     *
     * @param path путь к файлу, из которого будет считан объект
     * @return считанный объект, если чтение прошло успешно, иначе null
     */
    @Override
    public Object read(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
