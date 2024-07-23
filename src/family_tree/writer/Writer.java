package family_tree.writer;

import java.io.Serializable;

public interface Writer { // абстракция объекта который умеет записывать. два метода: сохранение и загрузка
    void save(Serializable serializable);
    Object read();
    void setPath(String path);

}
