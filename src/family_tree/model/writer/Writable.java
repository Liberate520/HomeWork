package family_tree.model.writer;

import java.io.Serializable;

public interface Writable<T extends Serializable> {
    boolean save(T object);
    T read();
}