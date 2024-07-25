package ru.gb.family_tree.writer;

import ru.gb.family_tree.Human;

import java.util.List;

public interface Writer {

    void serializationToFile();
    List<Human> restoringFromFile();

}
