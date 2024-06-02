package ru.gb.famaly_tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void saved(Famaly_tree famalyTree) throws IOException;
    Famaly_tree download() throws IOException, ClassNotFoundException;
}
