package model.io;

import java.io.Serializable;

public interface FamilyTreeIO {
    void save(Serializable serializable);
    Object read();
    void setPath(String path);
}