package model.writer;

import java.io.Serializable;

public interface Writable {
    String save(Serializable serializable);

    Object read();
}