package ru.gb.famaly_tree.model.filehandler;

import ru.gb.famaly_tree.model.ft.Famaly_tree;

import java.io.IOException;

public interface Writable {
    void saved(Famaly_tree famalyTree) throws IOException;
    Famaly_tree download() throws IOException, ClassNotFoundException;
}