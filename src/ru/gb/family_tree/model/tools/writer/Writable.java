package ru.gb.family_tree.model.tools.writer;

import java.io.Serializable;


public interface Writable<E extends Serializable> {
    boolean write(E serializable, String path);
    E read(String path);
}


//---------------------------------------------------------------------