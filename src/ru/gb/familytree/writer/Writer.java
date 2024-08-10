package ru.gb.familytree.writer;

import java.io.Serializable;

public interface Writer {
    public boolean save(Serializable serializable);
    public Object read();
    void setPath(String filePath);
}
