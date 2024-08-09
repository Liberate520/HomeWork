package familytree.model.util;

import java.io.IOException;
import java.io.Serializable;

public interface Reader {   
    Object readFromFile();
    void setPath(String path);
}