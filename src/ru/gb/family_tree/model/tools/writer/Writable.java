package ru.gb.family_tree.model.tools.writer;

import java.io.Serializable;


public interface Writable {
    boolean write(Serializable serializable, String path);
    Object read(String path);
}


//---------------------------------------------------------------------