package model.writer;

import model.tree.FamilyTree;

public interface Writable {

    boolean saveToFile(FamilyTree familyTree, String filePath);// сохранение данных в файл

    FamilyTree uploadFromFile (String filePath);// загрузка данных из файла

}
