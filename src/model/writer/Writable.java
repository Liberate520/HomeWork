package model.writer;

import model.tree.FamilyTree;

public interface Writable {

    boolean saveToFile(FamilyTree familyTree);// сохранение данных в файл

    FamilyTree uploadFromFile ();// загрузка данных из файла


}
