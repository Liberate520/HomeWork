package family_free.writer;

import java.io.Serializable;

public interface Writer {
    void write(Serializable human);
    Object read();
}
