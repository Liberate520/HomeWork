package writer;

import java.io.Serializable;

public interface Writer {

    //метод сохранения
    void save(Serializable serializable);

    //метод загрузки
    Object read();

    //путь к файлу
    void setPath(String path);
}
