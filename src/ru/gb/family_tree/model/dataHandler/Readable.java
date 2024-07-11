package ru.gb.family_tree.model.dataHandler;

import java.io.IOException;

public interface Readable {

    Object readData(String filename) throws IOException, ClassNotFoundException;

}
