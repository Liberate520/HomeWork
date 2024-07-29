package ru.gb.family_tree.writer;

import java.io.*;

/**
 * Класс {@code FileHandler} предоставляет методы для записи и чтения объектов
 * в/из файлов. Он реализует интерфейс {@link Writable} и использует сериализацию
 * для хранения и восстановления объектов.
 * <p>
 * Класс поддерживает следующие операции:
 * <ul>
 *     <li>Запись объекта в файл.</li>
 *     <li>Чтение объекта из файла.</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
public class FileHandler implements Writable {

    /**
     * Записывает объект {@code serializable} в файл по указанному пути.
     *
     * @param serializable объект, который необходимо записать в файл. Он должен
     *                     реализовывать интерфейс {@link Serializable}.
     * @param path путь к файлу, в который будет произведена запись. Если файл
     *             уже существует, его содержимое будет перезаписано.
     * @return {@code true}, если объект был успешно записан в файл; {@code false}
     *         в противном случае.
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
     * Читает объект из файла по указанному пути.
     *
     * @param path путь к файлу, из которого будет произведено чтение объекта.
     * @return объект, считанный из файла, или {@code null}, если произошла ошибка
     *         при чтении.
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
