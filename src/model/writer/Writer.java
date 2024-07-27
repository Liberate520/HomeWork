package model.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable) throws IOException;
    Object deserialize() throws IOException, ClassNotFoundException;
}
