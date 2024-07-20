package model.writer;

import java.io.Serializable;

public interface Writer {
    void write(Serializable serializable);
    Object read();
}
