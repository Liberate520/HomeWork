package writer;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable, String path);
    Object read(String path);
}
