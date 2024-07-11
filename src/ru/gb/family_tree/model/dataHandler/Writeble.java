package ru.gb.family_tree.model.dataHandler;

import java.io.IOException;

public interface Writeble {

    void writeData(Object object, String filename) throws IOException;

}
