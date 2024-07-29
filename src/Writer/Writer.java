package Writer;

import java.io.Serializable;

public interface Writer{
    boolean save(Serializable serializable);
    Object load();
    void setPath(String filePath);

}