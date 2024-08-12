package family_tree.model.writer;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);
    Object read();
    void setPath (String filePath);
    void clear();
}
