package family_tree.writer;


import java.io.IOException;

import java.io.Serializable;

public interface Writable {
    void writeExternal(Serializable serializable, String FilePath) throws IOException;
    Object readExternal(String FilePath) throws IOException, ClassNotFoundException;
}
