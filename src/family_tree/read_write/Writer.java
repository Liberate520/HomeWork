package family_tree.read_write;

import java.io.Serializable;

public interface Writer {
    void write(Serializable serializable);
    Object read();
    void setPath(String path);
}
