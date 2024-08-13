package familytree.model.util;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    void writeToFile(Serializable serializable);   
    void setPath(String path);
}