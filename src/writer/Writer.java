package writer;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);
    Serializable load();
    void setPath(String path);
}
