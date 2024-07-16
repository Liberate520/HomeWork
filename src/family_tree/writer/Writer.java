package family_tree.writer;

import java.io.Serializable;

public interface Writer {
    void Save(Serializable ft, String way);
    Object Input(String way);
}
