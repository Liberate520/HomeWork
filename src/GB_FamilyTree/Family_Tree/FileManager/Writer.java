package GB_FamilyTree.Family_Tree.FileManager;

import java.io.Serializable;

public interface Writer {

    // Метод сохранения
    void save(Serializable serializable);

    // Метод загрузки
    Object read();

    // Путь к файлу
    void setPath(String path);
}
