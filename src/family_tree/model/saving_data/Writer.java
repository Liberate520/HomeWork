package family_tree.model.saving_data;

import java.io.Serializable;

public interface Writer<T> {
    void writeData(T data);
    T readData();
}
