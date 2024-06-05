package family_tree;

import java.io.Serializable;

public interface WriteRead {
    boolean save(Serializable serializable, String pathName);
    Object read(String pathName);
}
