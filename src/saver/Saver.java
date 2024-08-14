package saver;

import java.io.Serializable;

public interface Saver {
    boolean save(Serializable serializable);
    Object restore();
    void setPath(String filePath);
}
