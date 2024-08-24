package model.writer;

import java.io.Serializable;

public interface Writer<T> {
//    void save(Serializable serializable);
    void save(T data);
    T read();
    void setPath(String filePath);
}
