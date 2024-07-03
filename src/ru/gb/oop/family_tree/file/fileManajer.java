package ru.gb.oop.family_tree.file;

import java.io.Serializable;

public class fileManajer implements Saver {

    @Override
    public boolean save(Serializable obj) {
        return false;
    }

    @Override
    public boolean load(Serializable obj) {
        return false;
    }
}
