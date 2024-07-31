package ru.gb.family_tree.writer;

import java.io.Serializable;

/**
 * Интерфейс для записи и чтения объектов.
 * <p>
 * Этот интерфейс определяет методы для записи сериализуемых объектов в файл и чтения объектов из файла.
 * </p>
 */
public interface Writable {

    /**
     * Записывает сериализуемый объект в указанный путь.
     *
     * @param serializable объект, который нужно записать, должен быть сериализуемым.
     * @param path путь к файлу, в который будет записан объект.
     * @return {@code true}, если запись прошла успешно, иначе {@code false}.
     */
    boolean write(Serializable serializable, String path);

    /**
     * Читает объект из указанного пути.
     *
     * @param path путь к файлу, из которого будет прочитан объект.
     * @return прочитанный объект, или {@code null}, если чтение не удалось.
     */
    Object read(String path);
}
