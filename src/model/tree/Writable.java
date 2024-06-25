package model.tree;

import java.io.Serializable;

public interface  Writable {
    boolean save(Serializable serializable, String fileName);
    Object read(String fileName);
}


