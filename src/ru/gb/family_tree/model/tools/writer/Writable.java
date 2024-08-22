package ru.gb.family_tree.model.tools.writer;

import java.io.Serializable;

/**
 * Интерфейс Writable определяет методы для записи и чтения сериализуемых объектов.
 *
 * @param <E> Тип объектов, которые должны быть сериализуемыми (реализуют интерфейс Serializable).
 */
public interface Writable<E extends Serializable> {

    /**
     * Записывает сериализуемый объект в файл.
     *
     * @param serializable Объект, который нужно записать в файл.
     * @param path Путь к файлу, в который будет записан объект.
     * @return Возвращает true, если запись прошла успешно, иначе false.
     */
    boolean write(E serializable, String path);

    /**
     * Читает сериализуемый объект из файла.
     *
     * @param path Путь к файлу, из которого будет прочитан объект.
     * @return Возвращает объект, если чтение прошло успешно, иначе null.
     */
    E read(String path);
}
