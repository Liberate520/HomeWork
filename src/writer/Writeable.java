package writer;

import java.io.Serializable;

public interface Writeable {
    boolean save(Serializable serializable);

    Object read();
}
