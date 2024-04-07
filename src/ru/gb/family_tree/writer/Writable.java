package ru.gb.family_tree.writer;

import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String filePath);

    Object read(String filepath);
}
