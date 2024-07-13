package Family_tree;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable tree, String path);
    Object read (String path); 
}
