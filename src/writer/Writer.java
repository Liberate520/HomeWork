package writer;

import java.io.Serializable;

public interface Writer {

    void oos(Serializable serializable);

    Object ois(Object obj);
}
