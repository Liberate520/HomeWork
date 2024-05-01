package homeWork.model.service;

import java.io.Serializable;

public interface Writable {
    void writeFile(Serializable serializable, String filename);
    Object readFile(String filename);
}
