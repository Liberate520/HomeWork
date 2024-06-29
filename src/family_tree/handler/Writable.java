package family_tree.handler;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String nameFile) throws IOException;
    Object read(String nameFile) throws IOException, ClassNotFoundException;

}
