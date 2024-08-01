package ru.gb.family_tree.model.tools.writer;

import java.io.Serializable;

/**
 * Интерфейс для работы с объектами, поддерживающими запись и чтение данных.
 * <p>
 * Этот интерфейс определяет методы для записи и чтения данных из файлов.
 * </p>
 */
public interface Writable {

    /**
     * Записывает объект в файл по указанному пути.
     *
     * @param serializable объект, реализующий интерфейс {@link Serializable}, который нужно записать
     * @param path путь к файлу, в который будет записан объект
     * @return {@code true} если запись прошла успешно, {@code false} в противном случае
     */
    boolean write(Serializable serializable, String path);

    /**
     * Читает объект из файла по указанному пути.
     *
     * @param path путь к файлу, из которого будет прочитан объект
     * @return объект, прочитанный из файла. Возвращаемое значение может быть {@code null} в случае ошибки чтения
     */
    Object read(String path);
}
