
package ru.gb.family.writer;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);
    Object read();
    void setPath(String path);

}