package Model.family_tree.Writer;

import java.io.Serializable;

public interface Writer extends Serializable {
    //метод сохранения метод загрузки
void Save(Serializable serializable);
Object Load();

}
