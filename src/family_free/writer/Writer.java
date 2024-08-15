package family_free.writer;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable);
    Object read();
    void  setPath(String filePath);
}
