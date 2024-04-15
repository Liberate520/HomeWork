package model.writer;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String fileName);

    Object read(String fileName);
}