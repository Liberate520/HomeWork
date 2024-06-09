package ru.gb.family_tree.saving_data;

import java.io.FileNotFoundException;
import java.io.IOException;
import ru.gb.family_tree.tree.FamilyTree;

public interface Writable {
    // Здесь обозначить методы сохранения и загрузки
    @SuppressWarnings("rawtypes")
    FamilyTree read_object(String target) throws FileNotFoundException, IOException, ClassNotFoundException;

    void write_object(Object obj, String target) throws FileNotFoundException, IOException;
}
