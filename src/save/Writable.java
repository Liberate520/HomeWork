package save;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePatch);
    Object load(String filePatch);
}
