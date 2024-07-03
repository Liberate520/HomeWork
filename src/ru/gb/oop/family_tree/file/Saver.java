package ru.gb.oop.family_tree.file;

import java.io.Serializable;

public interface Saver {
    boolean save(Serializable obj);
    boolean load(Serializable obj);
}
