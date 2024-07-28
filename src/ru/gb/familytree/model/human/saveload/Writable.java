package ru.gb.familytree.model.human.saveload;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String file);
    Object read(String file);
}
