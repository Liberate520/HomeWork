package ru.gb.family_tree.writer;

import java.io.Serializable;

//public interface Writable {
//boolean save(Serializable serializable, String filePath);
//    Object read(String filePath);
//}
public interface Writable {

    /**
     * Сохраняет сериализуемый объект в указанный файл.
     *
     * @param serializable объект, который нужно сохранить
     * @param filePath путь к файлу, куда будет сохранён объект
     * @return true, если сохранение прошло успешно, иначе false
     */
    boolean save(Serializable serializable, String filePath);

    /**
     * Читает сериализуемый объект из указанного файла.
     *
     * @param filePath путь к файлу, из которого будет прочитан объект
     * @return прочитанный объект, или null в случае ошибки
     */
    Object read(String filePath);
}