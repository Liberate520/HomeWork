package family_TREE.model.save;

import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
