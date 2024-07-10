package familytree.writer;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);
    Object read(String path);
    Object read();
    void setPath(String filePath);
}