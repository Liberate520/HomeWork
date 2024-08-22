package GB_Homework.Model.Service;

import java.io.Serializable;

public interface Writer {

    // Метод выбора пути к файлу
    void setFilePath(String filePath);

    // Метод сохранения
    void save(Serializable serializable);

    // Метод загрузки
    Object read();
}
